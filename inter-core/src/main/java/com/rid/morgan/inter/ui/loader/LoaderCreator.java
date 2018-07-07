package com.rid.morgan.inter.ui.loader;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

/**
 * Create by Morgan on 2018/7/3 0003
 * 使用HashMap以缓存的方式获取AVLoadingIndicatorView,
 * 不必每次使用都执行一次反射,提高效率
 */
public class LoaderCreator {

    private static final WeakHashMap<String,Indicator> LOADING_MAP = new WeakHashMap<>();

    static AVLoadingIndicatorView create(String type, Context context) {

        AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);

        if (LOADING_MAP.get(type) == null) {
            Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type,indicator);
        }

        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
        return avLoadingIndicatorView;
    }


    private static Indicator getIndicator(String name) {

        if(name == null || name.isEmpty()){
            return null;
        }
        //将name拼接到完整的包名下
        StringBuilder drawableClassName = new StringBuilder();
        if(!name.contains(".")){
            String defaultPackageName = AVLoadingIndicatorView.class.getPackage().getName();
            drawableClassName.append(defaultPackageName)
                    .append(".indicators")
                    .append(".");
        }
        drawableClassName.append(name);

        try {
            Class<?> drawableClass = Class.forName(drawableClassName.toString());
            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
