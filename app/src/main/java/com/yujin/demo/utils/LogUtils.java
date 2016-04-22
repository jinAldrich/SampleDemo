package com.yujin.demo.utils;

import com.orhanobut.logger.Logger;

/**
 *
 * 日志管理
 * 比原生Log
 * @author yujin 4/22/16
 *
 */
public class LogUtils {

    private static final String APP_TAG = "yujin";

    public LogUtils() {
        Logger.init(APP_TAG);
    }

    public static void LOGD(String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.w(message);
        }
    }

    public static void LOGD(String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.e(cause, message);
        }
    }

    public static void LOGV(String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.v(message);
        }
    }

    public static void LOGV(String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.v(message, cause);
        }
    }

    public static void LOGI(String message) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.i(message);
        }
    }

    public static void LOGI(String message, Throwable cause) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.i(message, cause);
        }
    }

    public static void LOGW(String message) {

        if (message == null) return;
        if (BuildConfig.DEBUG)
            Logger.w(message);
    }

    public static void LOGW(String message, Throwable cause) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.w(message, cause);
        }
    }

    public static void LOGE(String message) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.e(message);
        }
    }

    public static void LOGE(String message, Throwable cause) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.e(cause, message);
        }
    }

    public static void LOGE(String message, Exception ex) {
        if (message == null) return;
        if (BuildConfig.DEBUG) {
            Logger.e(ex, message);
        }
    }
}
