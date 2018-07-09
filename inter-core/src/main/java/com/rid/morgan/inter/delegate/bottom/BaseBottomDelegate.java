package com.rid.morgan.inter.delegate.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.joanzapata.iconify.widget.IconTextView;
import com.rid.morgan.inter.R;
import com.rid.morgan.inter.R2;
import com.rid.morgan.inter.delegate.InterDelegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * Create by Morgan on 2018/7/8 0008
 */
public abstract class BaseBottomDelegate extends InterDelegate implements View.OnClickListener{

    private static final String TAG = "BaseBottomDelegate";
    private final ArrayList<BottomTabBean> BEANS = new ArrayList<>();
    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
    private int mClickedColor = Color.RED;
    private int mCurrentDelegate = 0;//当前的fragment页面
    private int mIndexDelegate = 0;//当前tab

    public abstract LinkedHashMap<BottomTabBean,BottomItemDelegate> setItems(ItemBuilder builder);

    public abstract int setIndexDelegate();

    public abstract int setClickedColor();

    @BindView(R2.id.bottom_bar)
    LinearLayoutCompat mBottomBar = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }

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


    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        int size = ITEMS.size();
        for (int i = 0 ; i < size ; i++){//初始化下方每个tab
            Log.d(TAG,"size:"+size);
            LayoutInflater.from(getContext()).inflate(R.layout.delegate_item_icon_text,mBottomBar);
            RelativeLayout tab = (RelativeLayout) mBottomBar.getChildAt(i);
            //设置每个tab点击事件
            tab.setTag(i);
            tab.setOnClickListener(this);
            IconTextView itemIcon = (IconTextView) tab.getChildAt(0);
            AppCompatTextView itemText = (AppCompatTextView) tab.getChildAt(1);
            BottomTabBean bean = BEANS.get(i);
            itemIcon.setText(bean.getIcon());
            itemText.setText(bean.getTitle());
            if(i == mIndexDelegate){
                itemIcon.setTextColor(mClickedColor);
                itemText.setTextColor(mClickedColor);
            }
        }

        ISupportFragment[] delegateArray = ITEM_DELEGATES.toArray(new ISupportFragment[size]);
        loadMultipleRootFragment(R.id.bottom_bar_delegate_container,
                mIndexDelegate,
                delegateArray);

    }



    private void resetColor() {
        final int count = mBottomBar.getChildCount();
        Log.d(TAG,"count:"+count);
        for (int i = 0; i < count; i++) {
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            final IconTextView itemIcon = (IconTextView) item.getChildAt(0);
            itemIcon.setTextColor(Color.GRAY);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemTitle.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onClick(View v) {
        final int tag = (int) v.getTag();
        resetColor();
        final RelativeLayout item = (RelativeLayout) v;
        final IconTextView itemIcon = (IconTextView) item.getChildAt(0);
        itemIcon.setTextColor(mClickedColor);
        final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemTitle.setTextColor(mClickedColor);
        getSupportDelegate().showHideFragment(ITEM_DELEGATES.get(tag), ITEM_DELEGATES.get(mCurrentDelegate));
        //注意先后顺序
        mCurrentDelegate = tag;
    }
}
