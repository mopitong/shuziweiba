package com.mpt.demo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mpt.demo.R;
import com.mpt.demo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mpt on 2016/12/26.
 * 个人中心
 */

public class PersonalActivity extends BaseActivity {


    @BindView(R.id.tl_title)
    Toolbar mToolbar;
    @BindView(R.id.iv_logo)
    ImageView mLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {
        //使用glide直接加载圆形图片
        Glide.with(this).load("http://img5.imgtn.bdimg.com/it/u=1664676372,2608449173&fm=11&gp=0.jpg").asBitmap().centerCrop().into(new BitmapImageViewTarget(mLogo){
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                mLogo.setImageDrawable(circularBitmapDrawable);
            }
        });


    }
}
