package com.rid.morgan.inter.util.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rid.morgan.inter.app.Inter;


/**
 * Create by Morgan on 2018/7/7 0007
 */
public final class InterPreference {

    private static final SharedPreferences PREFERENCES =
            PreferenceManager.getDefaultSharedPreferences(Inter.getApplicationContext());

    private static final String APP_PREFERENCE_KEY = "profile";

    public static SharedPreferences getAppPreference(){
        return PREFERENCES;
    }

    public static void setAppProfile(String name){
        getAppPreference()
                .edit()
                .putString(APP_PREFERENCE_KEY,name)
                .apply();
    }

    public static String getAppProfile(){
        return getAppPreference().getString(APP_PREFERENCE_KEY,null);
    }

    public static JSONObject getAppProfileJson(){
        String profile = getAppProfile();
        return JSON.parseObject(profile);
    }

    public static void removeAppProfile(){
        getAppPreference()
                .edit()
                .remove(APP_PREFERENCE_KEY)
                .apply();
    }

    public static void clearAppPreferences(){
        getAppPreference()
                .edit()
                .clear()
                .apply();
    }

    /**
     * 设置APP是否为第一次启动
     * @param key
     * @param flag
     */
    public static void setAppFlag(String key,boolean flag){
        getAppPreference()
                .edit()
                .putBoolean(key,flag)
                .apply();
    }

    public static boolean getAppFlag(String key){
        return getAppPreference().getBoolean(key,false);
    }


    public static void addCustomAppProfile(String key, String val) {
        getAppPreference()
                .edit()
                .putString(key, val)
                .apply();
    }

    public static String getCustomAppProfile(String key) {
        return getAppPreference().getString(key, "");
    }




}
