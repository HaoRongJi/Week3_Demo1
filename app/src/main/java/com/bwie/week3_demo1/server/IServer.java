package com.bwie.week3_demo1.server;


import com.bwie.week3_demo1.entity.ShowEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IServer {

    @GET("product/searchProducts")
    Observable<ShowEntity> showData(@Query("keywords") String keywords,@Query("page") String page);


}
