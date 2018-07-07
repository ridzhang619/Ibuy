package com.rid.morgan.inter.ibuy.launcher;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.R2;
import com.rid.morgan.inter.ui.launcher.ScrollLauncherTag;
import com.rid.morgan.inter.util.storage.InterPreference;
import com.rid.morgan.inter.util.timer.BaseTimerTask;
import com.rid.morgan.inter.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create by Morgan on 2018/7/7 0007
 */
public class LauncherDelegate extends InterDelegate implements ITimerListener{

    private Timer mTimer;

    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView(){
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
            checkIsShowScrollLauncher();
        }
    }


    public void initTimer(){
        mTimer = new Timer();
        BaseTimerTask baseTimerTask = new BaseTimerTask(this);
        mTimer.schedule(baseTimerTask,0,1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onUnBindView() {

    }

    private void checkIsShowScrollLauncher(){
        if(!InterPreference.getAppFlag(ScrollLauncherTag.FIRST_LAUNCHER_APP.name())){
            start(new LauncherScrollDelegate(),SINGLETASK);
        }else{
            // TODO: 2018/7/7 0007 检查用户是否登录
        }
    }

    @Override
    public void onTimer() {
        getInterActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mTimer != null){
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s",mCount));
                    mCount --;
                    if(mCount < 0){
                        mTimer.cancel();
                        mTimer = null;
                        checkIsShowScrollLauncher();
                    }
                }
            }
        });
    }
}
