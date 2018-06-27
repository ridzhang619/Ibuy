package com.rid.morgan.ibuy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;

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

    }
}
