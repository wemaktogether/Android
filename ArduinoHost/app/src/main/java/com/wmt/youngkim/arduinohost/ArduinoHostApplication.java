package com.wmt.youngkim.arduinohost;

import android.app.Application;
import android.util.Log;

public class ArduinoHostApplication extends Application {
    private static final String TAG = "ArduinoHost";

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();

    }

    @Override
    public void onTerminate() {
        Log.i(TAG, "onTerminate");
        super.onTerminate();
    }

}
