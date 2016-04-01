package com.yujin.demo;

import android.app.Application;
import android.content.res.Configuration;
import android.net.Uri;

/**
 * Created by yujin on 16/4/1.
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();

    public static boolean Debug = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return super.checkUriPermission(uri, pid, uid, modeFlags);
    }
}
