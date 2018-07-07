package com.rid.morgan.ibuy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.IError;
import com.rid.morgan.inter.net.callback.IFailure;
import com.rid.morgan.inter.net.callback.IRequest;
import com.rid.morgan.inter.net.callback.ISuccess;

import java.util.HashMap;

/**
 * Create by Morgan on 2018/6/27 0027
 */
public class IbuyDelegate extends InterDelegate{

    private static final String TAG = "IbuyDelegate";

    @Override
    public Object setLayout() {
        Log.d("TAG","IbuyDelegate");
        return R.layout.delegate_ibuy;//给BaseDelegate返回布局文件
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        Log.d(TAG,"onBindView");
        textRetrofit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG,"sleep");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void onUnBindView() {

    }

    private void textRetrofit() {
        RestClient.builder()
//                .url("https://www.baidu.com/")
                .url("https://127.0.0.1/index")
                .params(new HashMap<String, Object>())
                .loader(getContext())
                .onRequest(new IRequest() {
                    @Override
                    public void onRequestStart() {

                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.d(TAG,""+response);
//                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG,"code:"+code+"msg:"+msg);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG,"onFailure");
                    }
                })
                .build()
                .get();

    }
}
