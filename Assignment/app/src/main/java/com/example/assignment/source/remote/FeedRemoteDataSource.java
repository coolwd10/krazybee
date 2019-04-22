package com.example.assignment.source.remote;

import com.example.assignment.android.mvp.main.home.model.PhotoList;
import com.example.assignment.source.IFeedDataSouce;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


public class FeedRemoteDataSource implements IFeedDataSouce {

    private FeedAPIService mFeedAPIService;

    public FeedRemoteDataSource(FeedAPIService feedAPIService) {
        mFeedAPIService = feedAPIService;
    }

    @Override
    public Observable<ResponseBody> getFeeds() {
        return mFeedAPIService.getFeedList("/albums");
    }

    @Override
    public Observable<List<PhotoList>> getPhotoList(String id) {
        return mFeedAPIService.getPhotoList(id);
    }
}
