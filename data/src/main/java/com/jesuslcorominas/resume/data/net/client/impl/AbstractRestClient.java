package com.jesuslcorominas.resume.data.net.client.impl;

import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.util.Keys;
import com.jesuslcorominas.resume.data.net.client.RestClient;
import com.jesuslcorominas.resume.data.net.util.ServerResponse;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Nonnull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Jesús López Corominas
 */
public abstract class AbstractRestClient<VO, DTO, API> implements RestClient<VO> {

    protected final API api;
    private final ModelMapper mapper;

    private final Class<VO> voClass;
    private final Class<DTO> dtoClass;
    private final Type typeListVo;
    private final Type typeListDto;

    AbstractRestClient(API api, ModelMapper mapper, Class<VO> voClass, Class<DTO> dtoClass, TypeToken<List<VO>> typeListVo, TypeToken<List<DTO>> typeListDto) {
        this.api = api;
        this.mapper = mapper;

        this.voClass = voClass;
        this.dtoClass = dtoClass;
        this.typeListVo = typeListVo.getType();
        this.typeListDto = typeListDto.getType();
    }

    final void enqueueCall(@Nonnull Call<ServerResponse<List<DTO>>> call, @Nonnull final GetCallback<List<VO>> callback) {
        call.enqueue(new Callback<ServerResponse<List<DTO>>>() {
            @Override
            public void onResponse(@Nonnull Call<ServerResponse<List<DTO>>> call, @Nonnull Response<ServerResponse<List<DTO>>> response) {
                if (!response.isSuccessful()) {
                    // TODO lanzar error de peticion erronea
                    return;
                }

                ServerResponse<List<DTO>> body = response.body();
                if (body == null) {
                    // TODO lanzar error de respuesta nula
                    return;
                }

                int code = body.getCode();
                if (code != Keys.ResultCodes.ok) {
                    callback.onError(new ErrorInfo(code, body.getMessage()));
                    return;
                }

                List<VO> vos = mapper.map(body.getData(), typeListVo);
                callback.onSuccess(vos);
            }

            @Override
            public void onFailure(@Nonnull Call<ServerResponse<List<DTO>>> call, @Nonnull Throwable t) {
                // TODO procesar error
                // TODO interceptar el error en otro sitio??
                callback.onError(new ErrorInfo(Keys.ResultCodes.serverError, "Error al pedir el listado: " + t.getMessage()));
            }
        });
    }
}
