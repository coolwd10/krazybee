package com.example.assignment.android.mvp.core.base;

public interface BaseScreen {

    void showProgress();

    void hideProgress();

    void showError(String msg);
}
