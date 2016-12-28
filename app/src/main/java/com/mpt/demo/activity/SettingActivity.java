package com.mpt.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mpt.demo.R;
import com.mpt.demo.base.BaseActivity;
import com.mpt.demo.utils.EventUtil;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.theme;
import static android.R.attr.value;

/**
 * Created by mpt on 2016/12/26.
 */

public class SettingActivity extends BaseActivity {


    @BindView(R.id.tl_title)
    Toolbar mToolbar;
    @BindView(R.id.tv_one)
    TextView mTvnoe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        EventUtil.register(this);
        initVIew();
    }

    private void initVIew() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsg(String msg) {
        Logger.i("----------->>" + msg);

    }





    @OnClick(R.id.tv_one)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_one:
               EventUtil.post("测试eventbus用法");//测试eventbus用法
           break;

           default:
           break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventUtil.unregister(this);
    }
}
