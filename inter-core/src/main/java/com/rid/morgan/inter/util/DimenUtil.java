package com.rid.morgan.inter.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.rid.morgan.inter.app.Inter;

/**
 * Create by Morgan on 2018/7/3 0003
 */
public class DimenUtil {

    public static int getScreenWidth(){
        Resources resources = Inter.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();

        return dm.widthPixels;
    }
    public static int getScreenHeight(){
        Resources resources = Inter.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
