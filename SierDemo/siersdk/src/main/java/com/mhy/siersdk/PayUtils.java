package com.mhy.siersdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;
import com.alipay.security.mobile.module.commonutils.LOG;
import com.mhy.siersdk.bean.Costant;
import com.mhy.siersdk.init.SierSdk;
import com.mhy.siersdk.tools.Utils;

/**
 * 描述: 支付
 * Created by F.L on 2017/8/4.
 */

public class PayUtils {

    private static Context context = SierSdk.context;
    private static Handler mHandler = SierSdk.handler;
    private static final String content = "正在拉取支付...";
    /**
     * 支付宝支付
     * @param data
     */
    public static void zfbPay(final String data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //构造paytask对象
                PayTask alipay=new PayTask((Activity) context);
                //调用支付接口，获取支付结果
                String result=alipay.pay(data,true);
                Message msg=new Message();
                msg.what= Costant.PAY_ZFB;
                msg.obj=result;
                mHandler.sendMessage(msg);
            }
        }).start();
    }
    /**
     * 微信支付
     */
//    public static void wxPay(PayBean payBean) {
//        if (payBean == null) {
//            ToastUtils.showShortToast("微信支付返回信息为空");
//            return;
//        } else {
//            LogUtils.e("=================================="+payBean.toString());
//            ToastUtils.showShortToast("微信支付"+payType2);
//            IWXAPI api = WXAPIFactory.createWXAPI(mContext, null);
//            api.registerApp(payBean.getAppid());
//            PayReq request = new PayReq();
//            request.appId = payBean.getAppid();
//            request.partnerId = payBean.getPartnerid();
//            request.prepayId = payBean.getPrepayid();
//            request.nonceStr = payBean.getNoncestr();
//            request.timeStamp = payBean.getTimestamp();
//            request.packageValue = payBean.getPackageValues();
//            request.sign = payBean.getSign();
//            api.sendReq(request);
//            LogUtils.e("==================================");
//        }

//    }


}
