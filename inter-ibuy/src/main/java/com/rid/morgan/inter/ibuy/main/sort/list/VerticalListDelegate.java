package com.rid.morgan.inter.ibuy.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.R2;
import com.rid.morgan.inter.ibuy.main.sort.SortDelegate;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.ISuccess;
import com.rid.morgan.inter.ui.recycler.MultipleItemEntity;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class VerticalListDelegate extends InterDelegate{

    @BindView(R2.id.rv_vertical_list)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initRecyclerView();
        //在lazyInitView中加载数据
    }

    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        //屏蔽动画效果

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("http://193.112.244.87/sort_list.php")
                .params(new HashMap<String, Object>())
                .loader(getContext())//加载界面
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        List<MultipleItemEntity> data = new VerticalListDataConverter().setJsonData(response).convert();
                        SortDelegate delegate = getParentDelegate();
                        SortRecyclerAdapter adapter = new SortRecyclerAdapter(data,delegate);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onUnBindView() {

    }

}
