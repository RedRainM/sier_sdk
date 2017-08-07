package com.mhy.siersdk;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;


import com.mhy.siersdk.bean.Costant;
import com.mhy.siersdk.init.SierSdk;
import com.mhy.siersdk.tools.Utils;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


/**
 * 描述: 第三方登录
 * Created by F.L on 2017/7/24.
 */

public class ThirdLoginUtils {

    public static String loginType; // 区别登录类型


    private static final String content = "正在拉取登录权限...";
    private static Handler handler = SierSdk.handler;
    private static Context context = SierSdk.context;


    /**
     * 微信第三方登录
     */

    public static void weixinLogoin() {
        Utils.dialogShow(content);
        loginType = "2";
//        ShareSDK.initSDK(this);

        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);

        wechat.SSOSetting(true);

        if (!wechat.isClientValid()) {
            Toast.makeText(context,"微信未安装,请先安装微信",Toast.LENGTH_LONG).show();
        }
        authorize(wechat);
    }


    /**
     * QQ第三方登录
     */
    public static void qqLogin() {
        Utils.dialogShow(content);
        loginType = "4";
//       ShareSDK.initSDK(this);

        Platform qq = ShareSDK.getPlatform(QQ.NAME);

        qq.SSOSetting(true);

        authorize(qq);
    }

    /**
     * 第三方登录选择 要数据不要功能
     *
     * @paramplat
     */

    public static void authorize(Platform plat) {

        if (plat == null) {
            return;
        }
        plat.setPlatformActionListener(p);

        //关闭SSO授权
        plat.SSOSetting(false);

        plat.showUser(null);

    }


    static PlatformActionListener p = new PlatformActionListener() {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            System.out.println("登录成功回调--------:" + i + platform.getDb().exportData());
            if (i == Platform.ACTION_USER_INFOR) {
                Utils.dialogDismiss();
                Log.e("thirdlogin","授权成功");
                Message message = new Message();
                message.what = Costant.LOGIN_SUCCESS;
                message.obj = platform.getDb().exportData();
                handler.sendMessage(message);
            }
        }

        //登录成功回调
        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            System.out.println("登录失败回调------:" + i + platform.getDb().exportData());
            if (i == Platform.ACTION_USER_INFOR) {
                Utils.dialogDismiss();
                Log.e("thirdlogin","登录失败");
                Message message = new Message();
                message.what = Costant.LOGIN_FAIL;
                message.obj = platform.getDb().exportData();
                handler.sendMessage(message);
            }
            throwable.printStackTrace();
        }

        //登录取消回调
        @Override
        public void onCancel(Platform platform, int i) {
            System.out.println("登录取消回调:" + i + platform.getDb().exportData());
            if (i == Platform.ACTION_USER_INFOR) {
                Utils.dialogDismiss();
                Log.e("thirdlogin","登录取消");
                Message message = new Message();
                message.what = Costant.LOGIN_CANCEL;
                message.obj = platform.getDb().exportData();
                handler.sendMessage(message);
            }
        }
    };


}
