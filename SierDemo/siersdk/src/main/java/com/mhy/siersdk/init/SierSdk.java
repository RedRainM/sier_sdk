package com.mhy.siersdk.init;

import android.content.Context;
import android.os.Handler;

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

    public SierSdk() {
    }
    public static void init(Context context,Handler handler) {
        SierSdk.context = context;
        SierSdk.handler = handler;
        MobSDK.init(context);
    }
}
