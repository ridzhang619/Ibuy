package com.rid.morgan.ibuy;

import android.app.Application;
import android.content.Context;
import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.net.interceptors.DebugInterceptor;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class IbuyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Inter.init(this)
                .withApiHost("https://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }

}
