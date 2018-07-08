package com.rid.morgan.ibuy;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.ibuy.database.DatabaseManager;
import com.rid.morgan.inter.icon.FontIbuyModule;
import com.rid.morgan.inter.net.interceptors.DebugInterceptor;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class IbuyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Inter.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontIbuyModule())
                .withApiHost("https://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);
    }

}
