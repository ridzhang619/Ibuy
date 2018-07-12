package com.rid.morgan.inter.ui.recycler;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.entity.MultiItemEntity;


import java.util.ArrayList;
import java.util.List;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class IndexDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {

        JSONArray jsonArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        int size = jsonArray.size();
        Log.d("TAG","data size:"+size);
        for (int i = 0; i < size; i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String imageUrl = object.getString("imageUrl");
            String text = object.getString("text");
            int spanSize = object.getInteger("spanSize");
            int id  = object.getInteger("goodsId");
            JSONArray banners = object.getJSONArray("banners");
            Log.d("TAG","banners size:"+size);
            ArrayList<String> bannerImages = new ArrayList<>();

            int type = 0;

            if(imageUrl == null && text != null){
                type = ItemType.TEXT;
            }else if(imageUrl != null && text == null){
                type = ItemType.IMAGE;
            }else if(imageUrl != null){
                type = ItemType.IMAGE_TEXT;
            }else if(banners != null){
                type = ItemType.BANNER;
                int bannerSize = banners.size();
                for (int j = 0; j < bannerSize; j++) {
                    String bannerUrl = banners.getString(j);
                    bannerImages.add(bannerUrl);
                }
            }


            MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleType.ITEM_TYPE,type)
                    .setField(MultipleType.ID,id)
                    .setField(MultipleType.BANNERS,bannerImages)
                    .setField(MultipleType.IMAGE_URL,imageUrl)
                    .setField(MultipleType.SPAN_SIZE,spanSize)
                    .setField(MultipleType.TEXT,text)
                    .build();

            ENTITIES.add(entity);
        }


        return ENTITIES;
    }

}
