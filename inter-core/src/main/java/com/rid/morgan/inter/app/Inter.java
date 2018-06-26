package com.rid.morgan.inter.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public class Inter {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }


    private static WeakHashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getInterConfigs();
    }

}
