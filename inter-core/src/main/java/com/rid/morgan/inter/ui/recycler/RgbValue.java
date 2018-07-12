package com.rid.morgan.inter.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Create by Morgan on 2018/7/12 0012
 */
@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red,int green,int blue){
        return new AutoValue_RgbValue(red,green,blue);
    }


}
