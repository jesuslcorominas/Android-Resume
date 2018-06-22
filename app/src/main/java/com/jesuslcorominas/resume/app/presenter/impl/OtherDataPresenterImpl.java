package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.OtherDataPresenter;
import com.jesuslcorominas.resume.app.view.callbackview.OtherDataView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.commons.GetCallback;
import com.jesuslcorominas.resume.commons.model.OtherData;
import com.jesuslcorominas.resume.data.entity.OtherDataObjectBoxEntity;
import com.jesuslcorominas.resume.model.usecase.GetListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherDataPresenterImpl extends AbstractPresenter<OtherDataView> implements OtherDataPresenter {

    private GetListUseCase<OtherData> otherDataListUseCase;

    private ArrayList<OtherData> otherDataList;

    public OtherDataPresenterImpl(GetListUseCase<OtherData> otherDataListUseCase) {
        this.otherDataListUseCase = otherDataListUseCase;
    }

    @Override
    public void getOtherData() {
        if (resumed) {
            showProgressAndHideOthers();
        }

        otherDataListUseCase.execute(null, new GetCallback<List<OtherData>>() {
            @Override
            public void onSuccess(List<OtherData> data) {
                OtherDataPresenterImpl.this.otherDataList = new ArrayList<>();
                OtherDataPresenterImpl.this.otherDataList.addAll(data);

                if (resumed) {
                    showDataAndHideOthers();
                }
            }

            @Override
            public void onError(ErrorInfo error) {
                if (resumed) {
                    callbackView.showErrorGettingData(error);
                    showNoDataAndHideOthers();
                }
            }
        });
    }

    @Override
    public List<OtherData> getDatasource() {
        return otherDataList;
    }
}
