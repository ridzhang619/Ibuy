package com.rid.morgan.inter.ibuy.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;
import com.rid.morgan.inter.delegate.bottom.BottomItemDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.R2;
import com.rid.morgan.inter.ui.refresh.RefreshAssistant;

import butterknife.BindView;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class IndexDelegate extends BottomItemDelegate{


    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshAssistant mRefreshAssistant;

    private void initRefreshLayout(){
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        mRefreshAssistant.firstPage("http://193.112.244.87/index.php");
//        mRefreshAssistant.firstPage("http://www.baidu.com");

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        mRefreshAssistant = new RefreshAssistant(mRefreshLayout);
    }

    @Override
    public void onUnBindView() {

    }
}
