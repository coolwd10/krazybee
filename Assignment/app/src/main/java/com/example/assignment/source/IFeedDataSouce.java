package com.example.assignment.source;

import com.example.assignment.android.mvp.main.home.model.PhotoList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.Query;
import rx.Observable;


public interface IFeedDataSouce {

    Observable<ResponseBody> getFeeds();

    Observable<List<PhotoList>> getPhotoList(@Query("albumId") String id);

}
