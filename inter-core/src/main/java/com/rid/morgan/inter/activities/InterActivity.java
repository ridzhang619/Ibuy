package com.rid.morgan.inter.activities;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;

import com.rid.morgan.inter.R;
import com.rid.morgan.inter.delegate.InterDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public abstract class InterActivity extends SupportActivity{

    public abstract InterDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }


    private void initContainer(@Nullable Bundle savedInstanceState){
        @SuppressLint("RestrictedApi")
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container_id);
        setContentView(container);
        if(savedInstanceState == null){
            loadRootFragment(R.id.delegate_container_id,setRootDelegate());
        }
    }

}
