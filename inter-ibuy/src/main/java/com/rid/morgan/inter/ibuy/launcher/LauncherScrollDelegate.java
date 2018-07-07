package com.rid.morgan.inter.ibuy.launcher;

import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ui.launcher.LauncherHolderCreator;
import com.rid.morgan.inter.ui.launcher.ScrollLauncherTag;
import com.rid.morgan.inter.util.storage.InterPreference;

import java.util.ArrayList;

/**
 * Create by Morgan on 2018/7/7 0007
 */
public class LauncherScrollDelegate extends InterDelegate implements OnItemClickListener {


    private ConvenientBanner<Integer> mConvenientBanner;

    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner(){
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(),INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(true);
    }


    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onUnBindView() {
        if(INTEGERS.size() > 0){
            INTEGERS.clear();
        }
    }


    @Override
    public void onItemClick(int position) {
        //如果滑动到最后一张轮播图
        if(position == INTEGERS.size() - 1){
            InterPreference.setAppFlag(ScrollLauncherTag.FIRST_LAUNCHER_APP.name(),true);
            // TODO: 2018/7/7 0007  检查用户是否已经登录
        }
    }
}
