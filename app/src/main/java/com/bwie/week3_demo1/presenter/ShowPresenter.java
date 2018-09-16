package com.bwie.week3_demo1.presenter;

import android.util.Log;

import com.bwie.week3_demo1.contract.ShowContract;
import com.bwie.week3_demo1.entity.ShowEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static org.greenrobot.eventbus.EventBus.TAG;

public class ShowPresenter extends ShowContract.ShowPresenter {
    @Override
    public void showData(String keywords, String page) {
        mModel.showData(keywords, page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowEntity>() {
                    @Override
                    public void accept(ShowEntity showEntity) throws Exception {
                        mView.onSuccess(showEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "accept: 网络请求错误");
                        mView.onFailure(throwable.toString());
                    }
                });
    }
}
