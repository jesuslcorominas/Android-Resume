package com.jesuslcorominas.resume.app.presenter.impl;

import com.jesuslcorominas.resume.app.presenter.OtherDataPresenter;
import com.jesuslcorominas.resume.app.presenter.callbackview.OtherDataView;
import com.jesuslcorominas.resume.commons.ErrorInfo;
import com.jesuslcorominas.resume.data.entity.OtherData;
import com.jesuslcorominas.resume.model.usecase.ListUseCase;
import com.jesuslcorominas.resume.model.usecase.UseCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class OtherDataPresenterImpl extends AbstractPresenter<OtherDataView> implements OtherDataPresenter {

    private ListUseCase<OtherData> otherDataListUseCase;

    private ArrayList<OtherData> otherDataList;

    public OtherDataPresenterImpl(ListUseCase<OtherData> otherDataListUseCase) {
        this.otherDataListUseCase = otherDataListUseCase;
    }

    @Override
    public void getOtherData() {
        showProgressAndHideOthers();

        otherDataListUseCase.execute(null, new UseCase.Callback<List<OtherData>>() {
            @Override
            public void onSuccess(List<OtherData> data) {
                OtherDataPresenterImpl.this.otherDataList = new ArrayList<>();
                OtherDataPresenterImpl.this.otherDataList.addAll(data);

                showDataAndHideOthers();
            }

            @Override
            public void onError(ErrorInfo error) {
                callbackView.showErrorGettingData(error);
                showNoDataAndHideOthers();
            }
        });
    }

    @Override
    public ArrayList<OtherData> getDatasource() {
        return otherDataList;
    }
}
