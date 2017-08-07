package com.mhy.siersdk.init;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.mob.MobSDK;

/**
 * 描述: 初始化类
 * Created by F.L on 2017/8/4.
 */

public class SierSdk {
    // #log
    public static String TAG = "SierSdk";
    public static Context context;
    public static Handler handler;

    private SierSdk() {
        throw new UnsupportedOperationException("u can\'t instantiate me...");
    }

    public static void init(Context var0,Handler handler) {
        SierSdk.handler = handler;
        //初始化shareSDK
        MobSDK.init(var0);
        SierSdk.context = var0.getApplicationContext();
        Log.d(TAG,"initSuccess");
    }

    public static Handler getHandler() {
        if(context != null) {
            return handler;
        } else {
            throw new NullPointerException("u should init first");
        }
    }
    public static Context getContext() {
        if(context != null) {
            return context;
        } else {
            throw new NullPointerException("u should init first");
        }
    }
}
