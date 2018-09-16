package com.bwie.week3_demo1.app;

import android.app.Application;

import com.bwie.week3_demo1.utils.CrashHandler;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
