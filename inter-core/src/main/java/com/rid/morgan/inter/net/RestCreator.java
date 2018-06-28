package com.rid.morgan.inter.net;

import com.rid.morgan.inter.app.ConfigType;
import com.rid.morgan.inter.app.Inter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Create by Morgan on 2018/6/28 0028
 */
public class RestCreator {

    private RestCreator(){}

    public static RestService getRestSevice(){
        return RestServiceHolder.REST_SERVICE;
    }

    private static class RetrofitHolder{
        private static final String BASE_URL =
                (String) Inter.getConfigurations().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(OkHttpHolder.OK_HTTP_CLIENT)
                        .addConverterFactory(ScalarsConverterFactory.create())//转化器
                        .build();
    }

    private static class OkHttpHolder{
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .build();
    }

    private static class RestServiceHolder{
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }



}
