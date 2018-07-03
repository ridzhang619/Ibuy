package com.rid.morgan.inter.net;

import android.content.Context;

import com.rid.morgan.inter.net.callback.IError;
import com.rid.morgan.inter.net.callback.IFailure;
import com.rid.morgan.inter.net.callback.IRequest;
import com.rid.morgan.inter.net.callback.ISuccess;
import com.rid.morgan.inter.ui.LoaderStyle;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Create by Morgan on 2018/7/2 0002
 */
public class RestClientBuilder {

    private  String mUrl;
    private  Map<String,Object> mParams;
    private  IRequest mIRequest;
    private  ISuccess mISuccess;
    private  IFailure mIFailure;
    private  IError mIError;
    private  RequestBody mBody;
    private  Context mContext;
    private  LoaderStyle mLoaderStyle;


    RestClientBuilder(){//只允许同包创建此实例

    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String,Object> params){
        this.mParams = params;
        return this;
    }

    public final RestClientBuilder params(String key,Object value){//重载
        if (mParams == null){
            mParams = new HashMap<>();
        }
        this.mParams.put(key,value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request){
        this.mIRequest = request;
        return this;
    }

    public final RestClientBuilder success(ISuccess success){
        this.mISuccess = success;
        return this;
    }
    public final RestClientBuilder failure(IFailure failure){
        this.mIFailure = failure;
        return this;
    }
    public final RestClientBuilder error(IError error){
        this.mIError = error;
        return this;
    }

    public final RestClientBuilder loader(Context context , LoaderStyle loaderStyle){
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }
    public final RestClientBuilder loader(Context context){//重载
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }


    public final RestClient build(){
        return new RestClient(mUrl,mParams,mIRequest,mISuccess,mIFailure,mIError,mBody,mContext,mLoaderStyle);
    }






}
