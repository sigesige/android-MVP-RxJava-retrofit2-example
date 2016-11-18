package com.hond.mvpexample.Utils;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hond on 11/17/2016.
 */

public class ApplicationContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
