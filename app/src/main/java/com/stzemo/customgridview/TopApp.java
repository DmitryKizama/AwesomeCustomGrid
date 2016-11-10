package com.stzemo.customgridview;

import android.app.Application;

import com.stzemo.customgridview.helper.ScreenParametrs;
import com.stzemo.customgridview.helper.UilController;

public class TopApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UilController.initialize(getApplicationContext());
        ScreenParametrs.initialize(this);
    }


}
