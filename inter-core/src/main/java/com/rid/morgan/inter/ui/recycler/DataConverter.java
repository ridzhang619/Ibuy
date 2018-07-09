package com.rid.morgan.inter.ui.recycler;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Create by Morgan on 2018/7/9 0009
 */
public abstract class DataConverter {

     public final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();

     private String mJsonData;

     public abstract ArrayList<MultipleItemEntity> convert();

     public DataConverter setJsonData(String data){
         this.mJsonData = data;
         return this;
     }

     public String getJsonData(){
         if(mJsonData == null || mJsonData.isEmpty()){
             throw new NullPointerException("json data must has value");
         }
         return mJsonData;
     }

}
