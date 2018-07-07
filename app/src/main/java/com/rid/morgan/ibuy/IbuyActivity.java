package com.rid.morgan.ibuy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.rid.morgan.inter.activities.InterActivity;
import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.launcher.LauncherDelegate;
import com.rid.morgan.inter.ibuy.launcher.LauncherScrollDelegate;
import com.rid.morgan.inter.ibuy.sign.SignUpDelegate;

public class IbuyActivity extends InterActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public InterDelegate setRootDelegate() {
        Log.d("TAG","IbuyActivity");
        return new SignUpDelegate();
    }


}
