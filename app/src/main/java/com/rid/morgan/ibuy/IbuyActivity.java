package com.rid.morgan.ibuy;


import android.util.Log;

import com.rid.morgan.inter.activities.InterActivity;
import com.rid.morgan.inter.delegate.InterDelegate;

public class IbuyActivity extends InterActivity {

    @Override
    public InterDelegate setRootDelegate() {
        Log.d("TAG","IbuyActivity");
        return new IbuyDelegate();
    }


}
