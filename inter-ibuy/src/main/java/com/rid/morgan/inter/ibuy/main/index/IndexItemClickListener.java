package com.rid.morgan.inter.ibuy.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.rid.morgan.inter.delegate.bottom.BaseBottomDelegate;
import com.rid.morgan.inter.ibuy.details.GoodsDetailDelegate;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class IndexItemClickListener extends SimpleClickListener {

    private BaseBottomDelegate delegate;

    public IndexItemClickListener(BaseBottomDelegate delegate) {
        this.delegate = delegate;
    }

    public static IndexItemClickListener create(BaseBottomDelegate delegate){
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        delegate.start(GoodsDetailDelegate.create());
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

}
