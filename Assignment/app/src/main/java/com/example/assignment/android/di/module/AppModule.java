package com.example.assignment.android.di.module;

import android.app.Application;
import android.content.Context;


import com.example.assignment.android.util.Prefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application mContext;

    public AppModule(Application context) {
        mContext = context;
    }

    @Singleton
    @Provides
    public Application provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    public static Prefs providePrefs(Context context) {
        return new Prefs(context);
    }
}
