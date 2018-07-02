package com.rid.morgan.inter.net.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Create by Morgan on 2018/7/2 0002
 */
public class RequestCallbacks implements Callback<String>{

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public RequestCallbacks(IRequest request,
                            ISuccess success,
                            IFailure failure,
                            IError error) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){//请求成功
            if(call.isExecuted()){//call执行了
                if(SUCCESS != null){
                    SUCCESS.onSuccess(response.body());
                }
            }
        }else{
            if(ERROR != null){
                ERROR.onError(response.code(),response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(FAILURE != null){
            FAILURE.onFailure();
        }
        if(REQUEST != null){
            REQUEST.onRequestEnd();
        }
    }


}
