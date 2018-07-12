package com.rid.morgan.inter.ui.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.rid.morgan.inter.R;

/**
 * Create by Morgan on 2018/7/10 0010
 */
public class ImageHolder implements Holder<String>{

    private ImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);

        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Glide.with(context)
                .load(data)
                .into(mImageView);
    }


}
