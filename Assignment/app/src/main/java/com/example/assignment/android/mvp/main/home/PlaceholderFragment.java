package com.example.assignment.android.mvp.main.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.assignment.R;

public class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Here we inflate the layout we created above
        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        //gridView.setAdapter(new MyAdapter(HomeActivity.this.getApplicationContext()));

        return rootView;
    }
}
