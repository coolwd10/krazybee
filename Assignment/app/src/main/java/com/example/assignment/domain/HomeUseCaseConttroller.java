package com.example.assignment.domain;

import android.net.Uri;


import com.example.assignment.android.mvp.main.home.model.ListRessponce;
import com.example.assignment.android.mvp.main.home.model.PhotoList;
import com.example.assignment.domain.IView.IHomeUseCase;
import com.example.assignment.source.IFeedDataSouce;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;


public class HomeUseCaseConttroller implements IHomeUseCase {
    IFeedDataSouce mFeedDataSouce;

    @Inject
    public HomeUseCaseConttroller(IFeedDataSouce feedDataSouce) {
        mFeedDataSouce = feedDataSouce;
    }

    @Override
    public Observable<ResponseBody> getFeeds() {
        return mFeedDataSouce.getFeeds();
    }

    @Override
    public Observable<List<PhotoList>> getPhotoList(String id) {
        return mFeedDataSouce.getPhotoList(id);
    }
}
