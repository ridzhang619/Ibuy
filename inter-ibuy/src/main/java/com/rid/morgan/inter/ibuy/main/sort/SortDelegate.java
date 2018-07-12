package com.rid.morgan.inter.ibuy.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rid.morgan.inter.delegate.bottom.BottomItemDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.main.sort.content.ContentDelegate;
import com.rid.morgan.inter.ibuy.main.sort.list.VerticalListDelegate;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class SortDelegate extends BottomItemDelegate{

    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onUnBindView() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        VerticalListDelegate delegate = new VerticalListDelegate();
        loadRootFragment(R.id.vertical_list_container,delegate);
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
    }
}
