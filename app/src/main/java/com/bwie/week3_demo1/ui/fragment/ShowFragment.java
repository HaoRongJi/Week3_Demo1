package com.bwie.week3_demo1.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.week3_demo1.R;
import com.bwie.week3_demo1.contract.ShowContract;
import com.bwie.week3_demo1.entity.ShowEntity;
import com.bwie.week3_demo1.presenter.ShowPresenter;
import com.bwie.week3_demo1.ui.activity.ShowAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hao.base.base.mvp.BaseMvpFragment;
import com.hao.base.base.mvp.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowFragment extends BaseMvpFragment<ShowContract.IShowModel, ShowContract.ShowPresenter> implements ShowContract.IShowView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.smartrefresh_layout)
    SmartRefreshLayout smartrefreshLayout;
    Unbinder unbinder;
    private int page = 1;
    private String keywords = "笔记本";
    private ShowAdapter showAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.showfragment_layout;
    }

    @Override
    protected void initData() {
        super.initData();

         /*int x=1;
         int y=0;
         int i=x/y;
        System.out.println(i);*/


        presenter.showData(keywords, page + "");

    }

    @Override
    public BasePresenter initPresenter() {
        return new ShowPresenter();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void fail(String Msg) {

    }

    @Override
    public void onSuccess(ShowEntity showEntity) {
        Toast.makeText(getActivity(), showEntity.getMsg(), Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        showAdapter = new ShowAdapter(R.layout.show_item_layout, showEntity.getData(),getActivity());
        recyclerView.setAdapter(showAdapter);
        /*showAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                adapter.remove(position);
            }
        });*/

    }

    @Override
    public void onFailure(String Msg) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
