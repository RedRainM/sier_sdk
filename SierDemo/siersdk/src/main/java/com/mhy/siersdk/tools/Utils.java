package com.mhy.siersdk.tools;

import android.content.Context;
import android.graphics.Color;

import com.mhy.siersdk.dialog.XLoadingDialog;
import com.mhy.siersdk.init.SierSdk;

/**
 * 描述:  工具类
 * Created by F.L on 2017/8/4.
 */

public class Utils {

    private static XLoadingDialog xLoadingDialog;

    private static Context context = SierSdk.context;

    public static void dialogShow(String title) {

        xLoadingDialog = XLoadingDialog.with(context)
                .setCanceled(false) //设置手动不可取消
                .setOrientation(XLoadingDialog.HORIZONTAL) //设置显示方式（水平或者垂直）
                .setBackgroundColor(Color.parseColor("#aa000000"))//设置对话框背景
                .setMessageColor(Color.WHITE)//设置消息字体颜色
                .setMessage(title);
    }

    public static void dialogDismiss() {
        xLoadingDialog.dismiss();
    }

}
