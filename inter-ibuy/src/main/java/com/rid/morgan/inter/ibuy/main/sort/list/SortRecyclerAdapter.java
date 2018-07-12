package com.rid.morgan.inter.ibuy.main.sort.list;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.rid.morgan.inter.delegate.InterDelegate;
import com.rid.morgan.inter.ibuy.R;
import com.rid.morgan.inter.ibuy.main.sort.SortDelegate;
import com.rid.morgan.inter.ibuy.main.sort.content.ContentDelegate;
import com.rid.morgan.inter.ui.recycler.ItemType;
import com.rid.morgan.inter.ui.recycler.MultipleItemEntity;
import com.rid.morgan.inter.ui.recycler.MultipleRecyclerAdapter;
import com.rid.morgan.inter.ui.recycler.MultipleRecyclerHolder;
import com.rid.morgan.inter.ui.recycler.MultipleType;

import java.util.List;

/**
 * Create by Morgan on 2018/7/12 0012
 */
public class SortRecyclerAdapter extends MultipleRecyclerAdapter{

    private final SortDelegate DELEGATE;
    private int mPrePosition = 0;


    public SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        super(data);
        this.DELEGATE = delegate;

        //添加垂直布局
        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }


    @Override
    protected void convert(final MultipleRecyclerHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch(holder.getItemViewType()){
            case ItemType.VERTICAL_MENU_LIST:
                String text = entity.getField(MultipleType.TEXT);
                boolean isClicked = entity.getField(MultipleType.TAG);
                AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                View line = holder.getView(R.id.view_line);
                View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentPosition = holder.getAdapterPosition();
                        if(mPrePosition != currentPosition){
                            //还原上一个
                            getData().get(mPrePosition).setField(MultipleType.TAG,false);
                            notifyItemChanged(mPrePosition);
                            //更新选中的item
                            entity.setField(MultipleType.TAG,true);
                            notifyItemChanged(currentPosition);
                            mPrePosition = currentPosition;
                            int contentId = getData().get(currentPosition).getField(MultipleType.ID);
                            showContent(contentId);
                        }
                    }
                });

                if(!isClicked){
                    line.setVisibility(View.INVISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext,R.color.we_chat_black));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.item_background));
                }else{
                    line.setVisibility(View.VISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext,R.color.app_main));
                    line.setBackgroundColor(ContextCompat.getColor(mContext,R.color.app_main));
                    itemView.setBackgroundColor(Color.WHITE);
                }

                holder.setText(R.id.tv_vertical_item_name,text);
                break;
            default:
                break;
        }
    }

    private void showContent(int contentId){
        ContentDelegate delegate = ContentDelegate.newInstance(contentId);
        switchContent(delegate);
    }

    private void switchContent(ContentDelegate delegate) {
        InterDelegate contentDelegate = DELEGATE.findChildFragment(ContentDelegate.class);
        if(contentDelegate != null){
            contentDelegate.replaceFragment(delegate,false);
        }

    }
}
