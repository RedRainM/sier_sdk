package com.mhy.siersdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.mhy.siersdk.bean.Costant;
import com.mhy.siersdk.bean.ShareInfo;
import com.mhy.siersdk.init.SierSdk;
import com.mhy.siersdk.tools.Utils;

import java.util.HashMap;

import cn.sharesdk.alipay.friends.Alipay;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.tencent.weibo.TencentWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * 描述: 分享调用类
 * Created by F.L on 2017/8/4.
 */

public class ShareUtils {
    private static final String TAG = "ShareUtils";

    private static final String content = "正在拉取分享...";

    /**
     * 空间分享
     */
    public static void QZone(ShareInfo shareBean) {
        Utils.dialogShow(content);
        QZone.ShareParams sp = new QZone.ShareParams();
        sp.setTitleUrl(shareBean.url);
        sp.setTitle(shareBean.title);
        sp.setText(shareBean.description);
        sp.setImageUrl(shareBean.cover);
        Platform qzone = ShareSDK.getPlatform(QZone.NAME);
        qzone.setPlatformActionListener(platformActionListener); // 璁剧疆鍒嗕韩浜嬩欢鍥炶皟
        qzone.share(sp);
    }

    /**
     * qq好友分享
     */
    public static void QQ(ShareInfo shareBean) {
        Utils.dialogShow(content);
        QQ.ShareParams sp = new QQ.ShareParams();
        sp.setTitle(shareBean.title);
        sp.setText(shareBean.description);
        sp.setTitleUrl(shareBean.url);
        sp.setImageUrl(shareBean.cover);
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.setPlatformActionListener(platformActionListener);
        qq.share(sp);
    }

    /**
     * 微信分享
     */
    public static void Wechat(ShareInfo shareBean) {
        Utils.dialogShow(content);
        Wechat.ShareParams ws = new Wechat.ShareParams();
        ws.setTitle(shareBean.title);
        ws.setText(shareBean.description);
        ws.setImageUrl(shareBean.cover);
        ws.setUrl(shareBean.url);
        ws.setShareType(Platform.SHARE_WEBPAGE);
        Platform weixin = ShareSDK.getPlatform(Wechat.NAME);
        weixin.setPlatformActionListener(platformActionListener);
        weixin.share(ws);
    }

    /**
     * 微信朋友圈分享
     */
    public static void WechatMoments(ShareInfo shareBean) {
        Utils.dialogShow(content);
        WechatMoments.ShareParams ws1 = new WechatMoments.ShareParams();
        ws1.setTitle(shareBean.title);
        ws1.setUrl(shareBean.url);
        ws1.setImageUrl(shareBean.cover);
        ws1.setShareType(Platform.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(WechatMoments.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(ws1);
    }


    /**
     * 新浪微博分享
     */
    public static void SinaWeibo(ShareInfo shareBean) {
        Utils.dialogShow(content);
        SinaWeibo.ShareParams shareParams = new SinaWeibo.ShareParams();
        shareParams.setTitle(shareBean.title);
        shareParams.setUrl(shareBean.url);
        shareParams.setImageUrl(shareBean.cover);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(SinaWeibo.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(shareParams);
    }



    /**
     * 腾讯微博分享
     */
    public static void TencentWeibo(ShareInfo shareBean) {
        Utils.dialogShow(content);
        TencentWeibo.ShareParams shareParams = new TencentWeibo.ShareParams();
        shareParams.setTitle(shareBean.title);
        shareParams.setUrl(shareBean.url);
        shareParams.setImageUrl(shareBean.cover);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(TencentWeibo.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(shareParams);
    }


    /**
     * Facebook分享
     */
    public static void Facebook(ShareInfo shareBean) {
        Utils.dialogShow(content);
        Facebook.ShareParams shareParams = new Facebook.ShareParams();
        shareParams.setTitle(shareBean.title);
        shareParams.setUrl(shareBean.url);
        shareParams.setImageUrl(shareBean.cover);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(Facebook.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(shareParams);
    }
    /**
     * ZFB分享
     */
    public static void Alipay(ShareInfo shareBean) {
        Utils.dialogShow(content);
        Alipay.ShareParams shareParams = new Facebook.ShareParams();
        shareParams.setTitle(shareBean.title);
        shareParams.setUrl(shareBean.url);
        shareParams.setImageUrl(shareBean.cover);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(Alipay.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(shareParams);
    }
    /**
     * GooglePlus分享
     */
    public static void GooglePlus(ShareInfo shareBean) {
        Utils.dialogShow(content);
        GooglePlus.ShareParams shareParams = new GooglePlus.ShareParams();
        shareParams.setTitle(shareBean.title);
        shareParams.setUrl(shareBean.url);
        shareParams.setImageUrl(shareBean.cover);
        shareParams.setShareType(GooglePlus.SHARE_WEBPAGE);
        Platform pengyouquan = ShareSDK.getPlatform(GooglePlus.NAME);
        pengyouquan.setPlatformActionListener(platformActionListener);
        pengyouquan.share(shareParams);
    }



    /**
     * 分享的回调
     */
    static PlatformActionListener platformActionListener = new PlatformActionListener() {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            // 成功
            Utils.dialogDismiss();
            Log.e(TAG,"分享成功");
            Message msg = new Message();
            msg.what = Costant.SHARE_SUCCESS;
            SierSdk.getHandler().sendMessage(msg);
        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            // 失敗
            Utils.dialogDismiss();
            //打印错误信息,print the error msg
            throwable.printStackTrace();
            //错误监听,handle the error msg
            Log.e(TAG,"分享失败");
            Message msg = new Message();
            msg.what = Costant.SHARE_FAIL;
            SierSdk.getHandler().sendMessage(msg);
            Log.e("分享失败原因",throwable.toString());
        }

        @Override
        public void onCancel(Platform platform, int i) {
            // 取消
            Utils.dialogDismiss();
            Log.e(TAG,"分享取消");
            Message msg = new Message();
            msg.what = Costant.SHARE_CANCEL;
            SierSdk.getHandler().sendMessage(msg);
        }
    };



}
