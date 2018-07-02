package com.rid.morgan.inter.net;

import com.rid.morgan.inter.net.callback.IError;
import com.rid.morgan.inter.net.callback.IFailure;
import com.rid.morgan.inter.net.callback.IRequest;
import com.rid.morgan.inter.net.callback.ISuccess;
import com.rid.morgan.inter.net.callback.RequestCallbacks;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Create by Morgan on 2018/6/27 0027
 */
public class RestClient {

    private final String URL;
    private final Map<String,Object> PARAMS;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    private void request(HttpMethod method){
        RestService service = RestCreator.getRestSevice();
        Call<String> call = null;

        if (REQUEST != null){
            REQUEST.onRequestStart();
        }

        switch(method){
            case GET:
                call = service.get(URL,PARAMS);
                break;
            case POST:
                call = service.post(URL,PARAMS);
                break;
            case PUT:
                call = service.put(URL,PARAMS);
                break;
            case DELETE:
                call = service.delete(URL,PARAMS);
                break;
            default:
                break;
        }

        if(call != null){
            call.enqueue(getCallback());//运行在子线程
        }


    }

    private Callback<String> getCallback(){
        return new RequestCallbacks(REQUEST,SUCCESS,FAILURE,ERROR);
    }

    public final void get(){
        request(HttpMethod.GET);
    }
    public final void post(){
        request(HttpMethod.POST);
    }
    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }


}
