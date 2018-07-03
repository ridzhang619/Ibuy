package com.rid.morgan.inter.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.rid.morgan.inter.R;
import com.rid.morgan.inter.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Morgan on 2018/7/3 0003
 */
public class InterLoader {

    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    /**
     * 使用集合统一管理dialog
     */
    private static final List<AppCompatDialog> LOADERS = new ArrayList<>();

    /**
     * 提供一个默认的dialog样式
     */
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context , Enum<LoaderStyle> type){
        showLoading(context,type.name());
    }

    public static void showLoading(Context context , String type){

        AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type,context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        Window window = dialog.getWindow();
        if(window != null){
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = deviceWidth/LOADER_SIZE_SCALE;
            lp.height = deviceHeight/LOADER_SIZE_SCALE;
            lp.height = lp.height+deviceHeight/LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }

        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context){
        showLoading(context,DEFAULT_LOADER);
    }

    public static void stopLoading(){
        for (AppCompatDialog dialog : LOADERS) {
            if(dialog != null && dialog.isShowing()){
                dialog.cancel();
            }
        }
    }

}
