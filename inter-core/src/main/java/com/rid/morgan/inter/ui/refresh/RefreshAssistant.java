package com.rid.morgan.inter.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.ISuccess;
import com.rid.morgan.inter.ui.recycler.DataConverter;
import com.rid.morgan.inter.ui.recycler.MultipleRecyclerAdapter;


import java.util.HashMap;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class RefreshAssistant implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener{//加载更多接口

    private SwipeRefreshLayout mRefreshLayout;
    private final PageBean BEAN;
    private final RecyclerView RECYCLWEVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    public RefreshAssistant(SwipeRefreshLayout mRefreshLayout, RecyclerView recyclerView, DataConverter converter, PageBean bean) {
        this.mRefreshLayout = mRefreshLayout;
        this.RECYCLWEVIEW = recyclerView;
        this.CONVERTER = converter;
        this.BEAN = bean;
        mRefreshLayout.setOnRefreshListener(this);
    }

    public static RefreshAssistant create(SwipeRefreshLayout mRefreshLayout, RecyclerView recyclerView, DataConverter converter){
        return new RefreshAssistant(mRefreshLayout,recyclerView,converter,new PageBean());
    }

    private void refresh(){
        mRefreshLayout.setRefreshing(true);
        Inter.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        },2000);
    }

    public void firstPage(String url){
        RestClient.builder()
                .url(url)
                .params(new HashMap<String, Object>())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        JSONObject object = JSONObject.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshAssistant.this,RECYCLWEVIEW);
                        RECYCLWEVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }


    @Override
    public void onLoadMoreRequested() {

    }
}
