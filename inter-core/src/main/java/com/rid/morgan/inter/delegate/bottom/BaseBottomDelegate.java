package com.rid.morgan.inter.delegate.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Create by Morgan on 2018/7/8 0008
 */
public abstract class BaseBottomDelegate extends InterDelegate{

    private final ArrayList<BottomTabBean> BEANS = new ArrayList<>();
    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
    private int mClickedColor = Color.RED;
    private int mCurrentDelegate = 0;//当前的fragment页面
    private int mIndexDelegate = 0;//当前tab

    public abstract LinkedHashMap<BottomTabBean,BottomItemDelegate> setItems(ItemBuilder builder);

    public abstract int setIndexDelegate();

    public abstract int setClickedColor();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndexDelegate =setIndexDelegate();
        if(setClickedColor() != 0){
            mClickedColor = setClickedColor();
        }

        ItemBuilder builder =  ItemBuilder.builder();
        LinkedHashMap<BottomTabBean,BottomItemDelegate> items = setItems(builder);
        ITEMS.putAll(items);
        for (Map.Entry<BottomTabBean,BottomItemDelegate> item : ITEMS.entrySet()){
            BottomTabBean bean = item.getKey();
            BottomItemDelegate delegate = item.getValue();
            BEANS.add(bean);
            ITEM_DELEGATES.add(delegate);
        }
    }
}
