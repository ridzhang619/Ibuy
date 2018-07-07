package com.rid.morgan.inter.app;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class Inter {

    public static Configurator init(Context context){
        Configurator
                .getInstance()
                .getInterConfigs()
                .put(ConfigType.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }



    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext(){
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

}
