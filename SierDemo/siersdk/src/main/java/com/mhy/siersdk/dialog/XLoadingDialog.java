package com.mhy.siersdk.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mhy.siersdk.R;

public class XLoadingDialog extends Dialog {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static XLoadingDialog dialog;
    private Context context;
    private TextView loadingMessage;
    private ProgressBar progressBar;
    private LinearLayout loadingView;
    private XColorDrawable drawable;

    public XLoadingDialog(Context context) {
        super(context, R.style.loading_dialog);
        this.context=context;
        drawable = new XColorDrawable();
        setContentView(R.layout.xloading_dialog);
        loadingMessage = (TextView) findViewById(R.id.xframe_loading_message);
        progressBar = (ProgressBar) findViewById(R.id.xframe_loading_progressbar);
        loadingView = (LinearLayout) findViewById(R.id.xframe_loading_view);
        loadingMessage.setPadding(0,15,0,0);
        drawable.setColor(Color.WHITE);
        setBackground(loadingView,drawable);
    }

    public static XLoadingDialog with(Context context){
        if (dialog==null){
            dialog=new XLoadingDialog(context);
        }
        return dialog;
    }

    public XLoadingDialog setOrientation(int orientation){
        loadingView.setOrientation(orientation);
        if (orientation==HORIZONTAL){
           loadingMessage.setPadding(15,0,0,0);
        }else{
            loadingMessage.setPadding(0,15,0,0);
        }
        return dialog;
    }

    public XLoadingDialog setBackgroundColor(@ColorInt int color){
        drawable.setColor(color);
       setBackground(loadingView,drawable);
        return dialog;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (dialog!=null)
            dialog=null;
    }

    public XLoadingDialog setCanceled(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        setCancelable(cancel);
        return dialog;
    }

    public XLoadingDialog setMessage(String message) {
        if (!isSpace(message)) {
            loadingMessage.setText(message);
        }
        return this;
    }

    public XLoadingDialog setMessageColor(@ColorInt int color) {
        loadingMessage.setTextColor(color);
        return this;
    }
    /**
     * setBackgroundDrawable过时方法处理
     *
     * @param view
     * @param drawable
     */
    public static void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }
    /**
     * 判断字符串是否为null或全为空格
     *
     * @param s 待校验字符串
     * @return {@code true}: null或全空格<br> {@code false}: 不为null且不全空格
     */
    public static boolean isSpace(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
