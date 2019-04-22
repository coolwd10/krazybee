package com.example.assignment.android.mvp.main.home.mvp;

import com.example.assignment.android.mvp.core.base.BasePresenter;
import com.example.assignment.android.util.Utility;
import com.example.assignment.domain.HomeUseCaseConttroller;
import com.example.assignment.domain.IView.IHomeUseCase;
import com.example.assignment.source.IFeedDataSouce;

import org.json.JSONArray;
import org.json.JSONException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomePresenter extends BasePresenter {

    private IHomeUseCase mHomeViewUseCase;
    private IHomeView mIHomeView;

    @Inject
    HomePresenter(IFeedDataSouce feedDataSouce) {
        mHomeViewUseCase = new HomeUseCaseConttroller(feedDataSouce);
    }

    public void attacheScreen(IHomeView view) {
        super.attacheScreen(view);
        mIHomeView = view;
    }

    public void getList() {

        mIHomeView.showProgress();
        Observable<ResponseBody> response = mHomeViewUseCase.getFeeds();
        response.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {

            @Override
            public void onNext(ResponseBody responseBody) {
                mIHomeView.hideProgress();
                String resString = Utility.iStreamToString(responseBody.byteStream());
                //JSONObject resJsonObject =  Utility.getJsonObject(resString);
                JSONArray jsonArray =  null;
                try {
                    jsonArray =  new JSONArray(resString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mIHomeView.ShowView(jsonArray);

            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable t) {
                mIHomeView.hideProgress();
                mIHomeView.showError("Pleace chek after some time");
            }
        });

    }

    public void getPhotList() {

    }

}