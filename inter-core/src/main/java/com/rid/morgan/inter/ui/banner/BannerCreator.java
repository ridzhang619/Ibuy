package com.rid.morgan.inter.ui.banner;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.rid.morgan.inter.R;

import java.util.ArrayList;

/**
 * Create by Morgan on 2018/7/10 0010
 */
public class BannerCreator {

    public static void setDefault(ConvenientBanner<String> convenientBanner, ArrayList<String> banners, OnItemClickListener listener){
            convenientBanner.setPages(new HolderCreator(),banners)
                    .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                    .setOnItemClickListener(listener)
                    .startTurning(3000)
                    .setCanLoop(true);
    }
}
