package com.example.assignment.android.mvp.main.home.mvp;


import com.example.assignment.android.mvp.core.base.BaseScreen;

import org.json.JSONArray;

public interface IHomeView extends BaseScreen {
    void ShowView(JSONArray jsonArray);
}
