package com.bwie.week3_demo1.model;

import com.bwie.week3_demo1.contract.ShowContract;
import com.bwie.week3_demo1.entity.ShowEntity;
import com.bwie.week3_demo1.utils.RetrofitUtils;

import io.reactivex.Observable;

public class ShowModle implements ShowContract.IShowModel {

    @Override
    public Observable<ShowEntity> showData(String keywords, String page) {
        return RetrofitUtils.getInstance().getServer().showData(keywords,page);
    }
}
