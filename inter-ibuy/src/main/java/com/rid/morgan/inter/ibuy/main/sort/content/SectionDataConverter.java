package com.rid.morgan.inter.ibuy.main.sort.content;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.util.ArrayList;
import java.util.List;

/**
 * Create by Morgan on 2018/7/13 0013
 */
public class SectionDataConverter {

    List<SectionBean> convert(String json){
       List<SectionBean> dataList = new ArrayList<>();
        JSONArray array = JSON.parseObject(json).getJSONArray("data");
        int size = array.size();
        for (int i = 0; i < size; i++) {
            JSONObject data = array.getJSONObject(i);
            int id = data.getInteger("id");
            String title = data.getString("section");
            //添加title
            SectionBean sectionBean = new SectionBean(true,title);
            sectionBean.setId(id);
            sectionBean.setIsMore(true);
            dataList.add(sectionBean);

            JSONArray goods = data.getJSONArray("goods");
            int goodsSize = goods.size();
            for (int j = 0; j < goodsSize; j++) {
                JSONObject contentItem = goods.getJSONObject(j);
                int goodsId = contentItem.getInteger("goods_id");
                String goodsName = contentItem.getString("goods_name");
                String goodsThumb = contentItem.getString("goods_thumb");
                SectionContentItemEntity entity = new SectionContentItemEntity();
                entity.setGoodsId(goodsId);
                entity.setGoodsName(goodsName);
                entity.setGoodsThumb(goodsThumb);
                dataList.add(new SectionBean(entity));
            }
        }
        return dataList;
    }
}
