package com.rid.morgan.inter.ibuy.main.sort.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rid.morgan.inter.ui.recycler.DataConverter;
import com.rid.morgan.inter.ui.recycler.ItemType;
import com.rid.morgan.inter.ui.recycler.MultipleItemEntity;
import com.rid.morgan.inter.ui.recycler.MultipleType;

import java.util.ArrayList;

/**
 * Created by 傅令杰
 */

public final class VerticalListDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {

        final ArrayList<MultipleItemEntity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON
                .parseObject(getJsonData())
                .getJSONObject("data")
                .getJSONArray("list");

        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleType.ITEM_TYPE, ItemType.VERTICAL_MENU_LIST)
                    .setField(MultipleType.ID, id)
                    .setField(MultipleType.TEXT, name)
                    .setField(MultipleType.TAG, false)
                    .build();

            dataList.add(entity);
            //设置第一个被选中
            dataList.get(0).setField(MultipleType.TAG, true);
        }

        return dataList;
    }
}
