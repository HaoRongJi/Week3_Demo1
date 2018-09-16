package com.bwie.week3_demo1.ui.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.bwie.week3_demo1.R;
import com.bwie.week3_demo1.entity.ShowEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;

import java.util.List;

public class ShowAdapter extends BaseQuickAdapter<ShowEntity.DataBean,BaseViewHolder> {

    private SimpleDraweeView imgTv;
    private String images;
    private String[] split;
    private Context mContext;
    private int layoutPosition;

    public ShowAdapter(int layoutResId, @Nullable List<ShowEntity.DataBean> data, Context context) {
        super(layoutResId, data);
        mContext=context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ShowEntity.DataBean item) {
        helper.setText(R.id.show_tv,item.getTitle());

        imgTv = helper.getView(R.id.show_iv);
        images = item.getImages();
        split = images.split("\\|");
        imgTv.setImageURI(split[0]);



        helper.getView(R.id.right_to_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutPosition = helper.getLayoutPosition();

                Toast.makeText(mContext, "删除"+layoutPosition, Toast.LENGTH_SHORT).show();

                EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);

                easySwipeMenuLayout.resetStatus();

                remove(layoutPosition);
            }
        });
        /*helper.getView(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "setOnClickListener", Toast.LENGTH_SHORT).show();


            }
        });*/
    }

}
