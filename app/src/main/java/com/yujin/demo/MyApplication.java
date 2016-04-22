package com.yujin.demo;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.net.Uri;

import org.json.JSONObject;

/**
 * Created by yujin on 16/4/1.
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();

    public static boolean Debug = true;
    /**
     * 整个应用程序的上下文
     */
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }

    public JSONObject getDeatilContent() {
        AssetManager assetManager = this.getApplicationContext().getAssets();
        return null;
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
