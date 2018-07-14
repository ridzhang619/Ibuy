package com.rid.morgan.inter.ibuy.main.sort.content;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rid.morgan.inter.ibuy.R;

import java.util.List;

/**
 * Create by Morgan on 2018/7/14 0014
 */
public class SectionAdapter extends BaseSectionQuickAdapter<SectionBean,BaseViewHolder> {
    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate();

    public SectionAdapter(int layoutResId, int sectionHeadResId, List<SectionBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder holder, SectionBean bean) {
        holder.setText(R.id.header,bean.header);
        holder.setVisible(R.id.more,bean.isMore());
        holder.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder holder, SectionBean bean) {
        String thumb = bean.t.getGoodsThumb();
        String name = bean.t.getGoodsName();
        int goodsId = bean.t.getGoodsId();
        SectionContentItemEntity entity = bean.t;
        holder.setText(R.id.tv,name);
        AppCompatImageView goodsImageView = holder.getView(R.id.iv);
        Glide.with(mContext)
                .load(thumb)
                .into(goodsImageView);

    }
}
