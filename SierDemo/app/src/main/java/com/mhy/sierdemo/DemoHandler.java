package com.mhy.sierdemo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.mhy.siersdk.bean.Costant;

/**
 * 描述: 回调用
 * Created by F.L on 2017/8/4.
 */

public class DemoHandler extends Handler {

    private String TAG;
    public DemoHandler(String TAG) {
        this.TAG = TAG;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case Costant.LOGIN_SUCCESS:
                Log.e(TAG,"登录成功");
                break;
            case Costant.LOGIN_FAIL:
                Log.e(TAG,"登录失败");
                break;
            case Costant.LOGIN_CANCEL:
                Log.e(TAG,"登录取消");
                break;
            case Costant.SHARE_SUCCESS:
                Log.e(TAG,"分享成功");
                break;
            case Costant.SHARE_FAIL:
                Log.e(TAG,"分享失败");
                break;
            case Costant.SHARE_CANCEL:
                Log.e(TAG,"分享取消");
                break;
            case Costant.PAY_ZFB:
                String messge = (String) msg.obj;
                Log.e(TAG,"支付"+messge);
                break;
        }

    }
}
