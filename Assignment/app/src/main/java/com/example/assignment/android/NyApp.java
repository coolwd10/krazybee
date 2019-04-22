package com.example.assignment.android;

import android.app.Application;

import com.example.assignment.android.di.component.AppComponent;
import com.example.assignment.android.di.component.DaggerAppComponent;
import com.example.assignment.android.di.module.ApiModule;
import com.example.assignment.android.di.module.AppModule;
import com.example.assignment.android.di.module.DataModule;



public class NyApp extends Application {

    private AppComponent appComponent;
    private String BASE_URL = "https://jsonplaceholder.typicode.com";
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().apiModule(new ApiModule(BASE_URL))
                .appModule(new AppModule(this)).dataModule(new DataModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
