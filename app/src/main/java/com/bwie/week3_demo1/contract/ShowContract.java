package com.bwie.week3_demo1.contract;

import com.bwie.week3_demo1.entity.ShowEntity;
import com.bwie.week3_demo1.model.ShowModle;
import com.hao.base.base.mvp.BasePresenter;
import com.hao.base.base.mvp.IBaseModel;
import com.hao.base.base.mvp.IBaseView;

import io.reactivex.Observable;

public interface ShowContract {

    abstract class ShowPresenter extends BasePresenter<IShowModel,IShowView>{

        @Override
        public IShowModel getmModel() {
            return new ShowModle();
        }

        public abstract void showData(String keywords, String page);
    }

    interface IShowModel extends IBaseModel{

        Observable<ShowEntity> showData(String keywords,String page);

    }


    interface IShowView extends IBaseView{

        void onSuccess(ShowEntity showEntity);
        void onFailure(String Msg);

    }

}
