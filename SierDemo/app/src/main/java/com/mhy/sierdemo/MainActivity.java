package com.mhy.sierdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mhy.siersdk.PayUtils;
import com.mhy.siersdk.ShareUtils;
import com.mhy.siersdk.ThirdLoginUtils;
import com.mhy.siersdk.bean.Costant;
import com.mhy.siersdk.bean.ShareInfo;
import com.mhy.siersdk.init.SierSdk;
import com.mob.MobSDK;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ShareInfo shareInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DemoHandler handler = new DemoHandler(TAG);

//            SDK初始化
//          sHandler: 用于监测回调

        SierSdk.init(this,handler);

        //添加测试参数(分享)
        initView();
    }

    private void initView() {
        shareInfo = new ShareInfo();
        shareInfo.title = "毛毛雨";
        shareInfo.description = "美貌与智慧并存的男人";
        shareInfo.cover = "http://www.baidu.com";
        shareInfo.url = "https://user.qzone.qq.com/786630061/main";

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_qq_login:                  //QQ登录
                ThirdLoginUtils.qqLogin();
                break;
            case R.id.btn_wx_login:                  //微信登录
                ThirdLoginUtils.weixinLogoin();
                break;
            case R.id.btn_zfb_pay:                  //支付宝支付
                PayUtils.zfbPay("");
                break;
            case R.id.btn_wx_pay:                   //微信支付

                break;
            case R.id.btn_qq_share:                 //QQ分享
                ShareUtils.QQ(shareInfo);
                break;
            case R.id.btn_zone_share:               //QQZone分享
                ShareUtils.QZone(shareInfo);
                break;
            case R.id.btn_wx_share:                 //wx分享
                ShareUtils.Wechat(shareInfo);
                break;
            case R.id.btn_friend_share:             //朋友圈分享
                ShareUtils.WechatMoments(shareInfo);
                break;
        }
    }

}
