package com.rid.morgan.ibuy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.net.RestClient;
import com.rid.morgan.inter.net.callback.IError;
import com.rid.morgan.inter.net.callback.IFailure;
import com.rid.morgan.inter.net.callback.ISuccess;

/**
 * Create by Morgan on 2018/6/27 0027
 */
public class IbuyDelegate extends InterDelegate{

    @Override
    public Object setLayout() {
        Log.d("TAG","IbuyDelegate");
        return R.layout.delegate_ibuy;//给BaseDelegate返回布局文件
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        textRetrofit();
    }

    private void textRetrofit() {
        RestClient.builder()
                .url("https://www.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build()
                .get();

    }
}
