package com.rid.morgan.inter.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Toast;

import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.IError;
import com.rid.morgan.inter.net.callback.IFailure;
import com.rid.morgan.inter.net.callback.ISuccess;

import java.util.HashMap;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class RefreshAssistant implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout mRefreshLayout;

    public RefreshAssistant(SwipeRefreshLayout mRefreshLayout) {
        this.mRefreshLayout = mRefreshLayout;
        mRefreshLayout.setOnRefreshListener(this);
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
                        Toast.makeText(Inter.getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        Log.d("TAG",response);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(Inter.getApplicationContext(), code+msg, Toast.LENGTH_LONG).show();

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(Inter.getApplicationContext(), "failure", Toast.LENGTH_LONG).show();
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }


}
