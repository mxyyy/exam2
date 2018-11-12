package com.bwie.exam2;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * date:2018/11/12
 * author:mxy(M)
 * function:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ZXingLibrary.initDisplayOpinion(this);
    }
}
