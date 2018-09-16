package com.bwie.week3_demo1.utils;

import com.bwie.week3_demo1.api.Api;
import com.bwie.week3_demo1.server.IServer;
import com.hao.base.utils.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    //懒汉式加载
    public static RetrofitUtils retrofitUtils;
    private static IServer iServer;
    private static Retrofit retrofit;
    private static OkHttpClient client;
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            retrofitUtils=new RetrofitUtils();
        }
        return retrofitUtils;
    }
    //访问数据
    public IServer getServer(){
        return iServer==null?getRetrofit(IServer.class):iServer;
    }
    //实例化retrofit
    private <T> T getRetrofit(Class<T> service){
        retrofit = new Retrofit.Builder()
                .client(client())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_RELEASE_URL)
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient client() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
        return client;
    }


}
