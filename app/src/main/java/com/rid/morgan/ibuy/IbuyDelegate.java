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
    }

    private void textRetrofit() {
        RestClient.builder()
                .url("https://www.baidu.com/")
                .params(new HashMap<String, Object>())
                .loader(getContext())
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
