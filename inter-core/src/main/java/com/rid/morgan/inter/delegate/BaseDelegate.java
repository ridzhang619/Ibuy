package com.rid.morgan.inter.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rid.morgan.inter.activities.InterActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Create by Morgan on 2018/6/26 0026
 */
public abstract class BaseDelegate extends SwipeBackFragment{

    @SuppressWarnings("SpellCheckingInspection")//忽略单词拼写
    private Unbinder mUnbinder = null;
    public abstract Object setLayout();
    public abstract void onBindView(Bundle savedInstanceState,View rootView);
    public abstract void onUnBindView();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;

        if(setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof  View){
            rootView = (View) setLayout();
        }else{
            throw new RuntimeException("setLayout must be int or view");
        }
        if(rootView != null){
            mUnbinder = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }
        return rootView;
    }

    public InterActivity getInterActivity(){
        return (InterActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onUnBindView();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
