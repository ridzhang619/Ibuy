package com.rid.morgan.ibuy;

import android.app.Application;

import com.rid.morgan.inter.app.Inter;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class IbuyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Inter.init(this)
                .configure();
    }
}
