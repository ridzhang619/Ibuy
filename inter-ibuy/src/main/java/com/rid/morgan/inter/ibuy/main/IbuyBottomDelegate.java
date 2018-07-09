package com.rid.morgan.inter.ibuy.main;

import android.graphics.Color;

import com.rid.morgan.inter.delegate.bottom.BaseBottomDelegate;
import com.rid.morgan.inter.delegate.bottom.BottomItemDelegate;
import com.rid.morgan.inter.delegate.bottom.BottomTabBean;
import com.rid.morgan.inter.delegate.bottom.ItemBuilder;
import com.rid.morgan.inter.ibuy.main.index.IndexDelegate;
import com.rid.morgan.inter.ibuy.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class IbuyBottomDelegate extends BaseBottomDelegate{

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }

    @Override
    public void onUnBindView() {

    }
}
