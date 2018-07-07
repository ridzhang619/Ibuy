package com.rid.morgan.inter.util.timer;

import java.util.TimerTask;

/**
 * Create by Morgan on 2018/7/7 0007
 */
public class BaseTimerTask extends TimerTask{

    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if(mITimerListener != null){
            mITimerListener.onTimer();
        }
    }

}
