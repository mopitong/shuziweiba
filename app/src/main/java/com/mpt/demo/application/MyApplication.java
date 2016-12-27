package com.mpt.demo.application;

import android.app.Application;

import com.orhanobut.logger.Logger;


/**
 * Created by mpt on 2016/12/20.
 */

public class MyApplication extends Application{

    private static MyApplication app;

    public MyApplication() {
        app = this;
    }

    public static synchronized MyApplication getInstance() {
        if (app == null) {
            app = new MyApplication();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init();
    }
}
