package com.example.assignment.domain.IView;

import com.example.assignment.android.mvp.main.home.model.PhotoList;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;


public interface IHomeUseCase {
    Observable<ResponseBody> getFeeds();

    Observable<List<PhotoList>> getPhotoList(String id);
}
