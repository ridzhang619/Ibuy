package com.rid.morgan.inter.delegate;

/**
 * Create by Morgan on 2018/6/27 0027
 */
public abstract class InterDelegate extends PermissionCheckDelegate{


    public <T extends InterDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }


}
