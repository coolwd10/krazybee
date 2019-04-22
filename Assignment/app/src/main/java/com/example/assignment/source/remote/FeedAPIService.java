package com.example.assignment.source.remote;

import com.example.assignment.android.mvp.main.home.model.PhotoList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface FeedAPIService {
    @GET
    Observable<ResponseBody> getFeedList(@Url String url);

    @GET("photos")
    Observable<List<PhotoList>> getPhotoList(@Query("albumId") String id);
}
