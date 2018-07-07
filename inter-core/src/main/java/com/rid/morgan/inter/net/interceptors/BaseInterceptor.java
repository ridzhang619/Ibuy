package com.rid.morgan.inter.net.interceptors;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Create by Morgan on 2018/7/5 0005
 */
public abstract class BaseInterceptor implements Interceptor{


    protected LinkedHashMap<String,String> getUrlParameters(Chain chain){
        HttpUrl url = chain.request().url();
        int size = url.querySize();
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i),url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameters(Chain chain,String key){
        Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String,String> getBodyParameters(Chain chain){
        FormBody body = (FormBody) chain.request().body();
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        int size = body.size();
        for (int i = 0; i < size; i++) {
            params.put(body.name(i),body.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain,String key) {
        return getBodyParameters(chain).get(key);
    }



}
