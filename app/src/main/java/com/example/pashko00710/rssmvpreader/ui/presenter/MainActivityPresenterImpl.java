package com.example.pashko00710.rssmvpreader.ui.presenter;


import com.example.pashko00710.rssmvpreader.ui.view.IMainActivityView;

import javax.inject.Inject;

public class MainActivityPresenterImpl implements IMainActivityPresenter {

    private IMainActivityView view;

    @Inject
    public MainActivityPresenterImpl(IMainActivityView view) {
        this.view = view;
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
}
