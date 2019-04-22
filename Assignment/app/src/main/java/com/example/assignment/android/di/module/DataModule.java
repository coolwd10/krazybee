package com.example.assignment.android.di.module;


import com.example.assignment.source.FeedDataSourceHelper;
import com.example.assignment.source.IFeedDataSouce;
import com.example.assignment.source.remote.FeedAPIService;
import com.example.assignment.source.remote.FeedRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public final class DataModule {
    @Provides
    @Singleton
    public FeedAPIService provideFeedApiService(Retrofit retrofit) {
        return retrofit.create(FeedAPIService.class);
    }

    @Provides
    @Singleton
    public FeedRemoteDataSource provideFeedRemoteService(FeedAPIService feedAPIService) {
        return new FeedRemoteDataSource(feedAPIService);
    }

    @Singleton
    @Provides
    public IFeedDataSouce provideDataService(FeedRemoteDataSource feedRemoteDataSource) {
        return new FeedDataSourceHelper(feedRemoteDataSource);
    }


}
