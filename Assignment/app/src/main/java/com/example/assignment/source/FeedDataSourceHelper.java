package com.example.assignment.source;

import android.net.Uri;


import com.example.assignment.android.mvp.main.home.model.ListRessponce;
import com.example.assignment.android.mvp.main.home.model.PhotoList;
import com.example.assignment.source.remote.FeedRemoteDataSource;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


public class FeedDataSourceHelper implements IFeedDataSouce {

    FeedRemoteDataSource mFeedRemoteDataSource;

    public FeedDataSourceHelper(FeedRemoteDataSource feedRemoteDataSource) {
        mFeedRemoteDataSource = feedRemoteDataSource;
    }

    @Override
    public Observable<ResponseBody> getFeeds() {
        return mFeedRemoteDataSource.getFeeds();
    }

    @Override
    public Observable<List<PhotoList>> getPhotoList(String id) {
        return mFeedRemoteDataSource.getPhotoList(id);
    }
}
