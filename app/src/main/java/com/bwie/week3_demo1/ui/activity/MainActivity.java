package com.bwie.week3_demo1.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwie.week3_demo1.R;
import com.bwie.week3_demo1.contract.ShowContract;
import com.bwie.week3_demo1.entity.ShowEntity;
import com.bwie.week3_demo1.ui.fragment.ShowFragment;
import com.gyf.barlibrary.ImmersionBar;
import com.hao.base.base.mvp.BaseMvpActivity;
import com.hao.base.base.mvp.BasePresenter;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity  {


    @BindView(R.id.bottom_tabbar)
    BottomTabBar bottomTabbar;


    @Override
    public boolean getIsFullScreen() {
        return false;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void initView() {

        ImmersionBar.with(this);

        bottomTabbar.init(getSupportFragmentManager())
                .addTabItem("新品",R.mipmap.ic_launcher,ShowFragment.class)
                .addTabItem("首页",R.mipmap.ic_launcher,ShowFragment.class)
                .addTabItem("首页",R.mipmap.ic_launcher,ShowFragment.class)
                .addTabItem("首页",R.mipmap.ic_launcher,ShowFragment.class)
                .addTabItem("首页",R.mipmap.ic_launcher,ShowFragment.class)
                //.setImgSize(0,0)
                //.setTabPadding(1.0f,1.0f,1.0f)
                //.setDividerHeight(2.0f)
                //.setFontSize(18)
                //.isShowDivider(true)
                //.setChangeColor(R.color.colorAccent,R.color.colorPrimary)
        ;

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
