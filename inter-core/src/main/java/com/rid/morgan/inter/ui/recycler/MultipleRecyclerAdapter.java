package com.rid.morgan.inter.ui.recycler;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rid.morgan.inter.R;
import com.rid.morgan.inter.ui.banner.BannerCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class MultipleRecyclerAdapter extends BaseMultiItemQuickAdapter<MultipleItemEntity,MultipleRecyclerHolder>
        implements
        BaseQuickAdapter.SpanSizeLookup,OnItemClickListener {

    private boolean mIsInitBanner = false;

    public MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data){
        return new MultipleRecyclerAdapter(data);
    }
    public static MultipleRecyclerAdapter create(DataConverter converter){
        return new MultipleRecyclerAdapter(converter.convert());
    }

    private void init(){
        //设置不同item布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.IMAGE_TEXT, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
        //设置宽度监听
        setSpanSizeLookup(this);
        //打开加载动画
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    @Override
    protected MultipleRecyclerHolder createBaseViewHolder(View view) {
        return MultipleRecyclerHolder.create(view);
    }

    @Override
    protected void convert(MultipleRecyclerHolder holder, MultipleItemEntity entity) {
        //取数据
        String text;
        String image;
        ArrayList<String> bannerImages;
        switch(holder.getItemViewType()){
            case ItemType.TEXT:
                text = entity.getField(MultipleType.TEXT);
                holder.setText(R.id.item_single_text,text);
                break;
            case ItemType.IMAGE:
                image = entity.getField(MultipleType.IMAGE_URL);
                Glide.with(mContext)
                        .load(image)
                        .into((ImageView) holder.getView(R.id.item_single_image));

                break;
            case ItemType.IMAGE_TEXT:
                text = entity.getField(MultipleType.TEXT);
                image = entity.getField(MultipleType.IMAGE_URL);
                Glide.with(mContext)
                        .load(image)
                        .into((ImageView) holder.getView(R.id.item_image));
                holder.setText(R.id.item_text,text);
                break;
            case ItemType.BANNER:
                if(!mIsInitBanner){
                    bannerImages = entity.getField(MultipleType.BANNERS);
                    ConvenientBanner<String> convenientBanner = holder.getView(R.id.item_banner);
                    BannerCreator.setDefault(convenientBanner,bannerImages,this);
                    mIsInitBanner = true;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleType.SPAN_SIZE);
    }


    @Override
    public void onItemClick(int position) {

    }
}
