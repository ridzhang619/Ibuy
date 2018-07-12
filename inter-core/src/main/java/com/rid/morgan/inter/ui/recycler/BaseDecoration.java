package com.rid.morgan.inter.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class BaseDecoration extends DividerItemDecoration{



    public BaseDecoration(@ColorInt final int color, final int size) {

        setDividerLookup(new DividerLookup() {
            @Override
            public Divider getVerticalDivider(int position) {
                return new Divider.Builder()
                        .color(color)
                        .size(size)
                        .build();
            }

            @Override
            public Divider getHorizontalDivider(int position) {
                return new Divider.Builder()
                        .color(color)
                        .size(size)
                        .build();
            }
        });

    }

    public static BaseDecoration create(@ColorInt final int color, final int size){
        return new BaseDecoration(color,size);
    }

}
