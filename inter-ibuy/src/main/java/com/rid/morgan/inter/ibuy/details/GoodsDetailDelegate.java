package com.rid.morgan.inter.ibuy.details;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class GoodsDetailDelegate extends InterDelegate{

    public static GoodsDetailDelegate create(){
        return new GoodsDetailDelegate();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onUnBindView() {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
