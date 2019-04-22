package com.example.assignment.android.mvp.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.assignment.R;
import com.example.assignment.android.NyApp;
import com.example.assignment.android.mvp.core.base.BaseActivity;
import com.example.assignment.android.mvp.main.home.mvp.HomePresenter;
import com.example.assignment.android.mvp.main.home.mvp.IHomeView;
import com.example.assignment.android.util.DialogManager;
import com.example.assignment.android.util.Utility;

import org.json.JSONArray;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements IHomeView, DialogManager.NoticeDialogListener {

    private DialogManager mDialogManager;

    @Inject
    HomePresenter mPresenter;

    @BindView(R.id.pager)
    ViewPager mViewPager;


    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDI();
        mPresenter.attacheScreen(this);
        mDialogManager = new DialogManager(this);
        ButterKnife.bind(this);
        mPresenter.getList();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    private void initDI() {
        ((NyApp) getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgress() {
        Utility.showProgressDialog(this, null, true);
    }

    @Override
    public void hideProgress() {
        Utility.hideProgressDialog();
    }

    @Override
    public void showError(String msg) {
        mDialogManager.showAlertDialog(HomeActivity.this, msg,
                DialogManager.DIALOGTYPE.DIALOG, 102, DialogManager.MSGTYPE.INFO, "Warning",
                getResources().getString(R.string.global_OK_label), null, null, true);
    }

    @Override
    public void onDialogPositiveClick(int dialogId) {

    }

    @Override
    public void onDialogNegativeClick(int dialogId) {

    }

    @Override
    public void onDialogNeutralClick(int dialogId) {

    }

    @Override
    public void ShowView(JSONArray jsonArray) {
        Toast.makeText(getBaseContext(), (String) jsonArray.toString(),
                Toast.LENGTH_SHORT).show();
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new PlaceholderFragment();
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

}
