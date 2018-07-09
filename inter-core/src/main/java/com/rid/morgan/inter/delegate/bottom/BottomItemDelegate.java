package com.rid.morgan.inter.delegate.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.rid.morgan.inter.R;
import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.delegate.InterDelegate;

/**
 * Create by Morgan on 2018/7/8 0008
 */
public abstract class BottomItemDelegate extends InterDelegate {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Inter.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
