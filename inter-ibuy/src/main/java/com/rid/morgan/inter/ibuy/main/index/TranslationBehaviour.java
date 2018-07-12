package com.rid.morgan.inter.ibuy.main.index;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.YuvImage;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ui.recycler.RgbValue;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class TranslationBehaviour extends CoordinatorLayout.Behavior<Toolbar>{
    //顶部距离
    private int mDistanceY = 0;
    //颜色变化速度
    private static final int SHOW_SPEED = 3;
    //定义变化的颜色
    private final RgbValue RGB_VALUE = RgbValue.create(255,124,2);

    public TranslationBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        //增加滑动距离
        mDistanceY += dy;
        //toolbar的高度
        int targetHeight = child.getBottom();
        //当滑动时,并且距离小于toolbar高度 的时候,调整渐变色
        if(mDistanceY > 0 && mDistanceY <= targetHeight){
            float scale = (float)mDistanceY/targetHeight;
            float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int)alpha,RGB_VALUE.red(),RGB_VALUE.green(),RGB_VALUE.blue()));
        }else if(mDistanceY > targetHeight){
            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(),RGB_VALUE.green(),RGB_VALUE.blue()));
        }
    }
}
