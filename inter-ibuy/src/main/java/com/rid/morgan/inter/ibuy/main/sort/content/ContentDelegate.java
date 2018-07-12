package com.rid.morgan.inter.ibuy.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.R2;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.ISuccess;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class ContentDelegate extends InterDelegate{

    private static final String ARG_CONTENT_ID = "CONTENT_ID";
    private int mContentId = -1;

    @BindView(R2.id.rv_list_content)
    RecyclerView mRecyclerView = null;
    private List<SectionBean> mData = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if(args != null){
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    public static ContentDelegate newInstance(int contentId){
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_CONTENT_ID,contentId);
        ContentDelegate delegate = new ContentDelegate();
        delegate.setArguments(bundle);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_list_content;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initData();
    }

    private void initData(){
        RestClient.builder()
                .url("http://193.112.244.87/sort_content_list.php?contentId="+mContentId)
                .params(new HashMap<String, Object>())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        mData = new SectionDataConverter().convert(response);
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onUnBindView() {

    }
}
