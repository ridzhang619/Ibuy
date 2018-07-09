package com.rid.morgan.inter.ui.recycler;

import java.util.LinkedHashMap;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public class MultipleEntityBuilder {


    private final LinkedHashMap<Object,Object> FIELDS = new LinkedHashMap<>();

    public MultipleEntityBuilder() {
        FIELDS.clear();//清除之前数据
    }

    public final MultipleItemEntity build(){
        return new MultipleItemEntity(FIELDS);
    }

    public final MultipleEntityBuilder setItemType(int type){
        FIELDS.put(MultipleType.ITEM_TYPE,type);
        return this;
    }
    public final MultipleEntityBuilder setField(Object key,Object value){
        FIELDS.put(key,value);
        return this;
    }
    public final MultipleEntityBuilder setField(LinkedHashMap<Object,Object> fields){
        FIELDS.putAll(fields);
        return this;
    }



}
