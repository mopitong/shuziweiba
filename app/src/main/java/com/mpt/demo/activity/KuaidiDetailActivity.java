package com.mpt.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.baoyachi.stepview.VerticalStepView;
import com.mpt.demo.R;
import com.mpt.demo.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mpt on 2016/12/27.
 *
 *
 *
 */

public class KuaidiDetailActivity extends BaseActivity {

    @BindView(R.id.tl_title)
    Toolbar mToolbar;
    @BindView(R.id.step_view)
    VerticalStepView mStepView;

    private String mCom;
    private ArrayList<String> dataList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuaididetail);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        dataList = intent.getStringArrayListExtra("dataList");
        mCom = intent.getStringExtra("com");
    }

    private void initView() {

        mToolbar.setTitle(mCom);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mStepView.setStepsViewIndicatorComplectingPosition(dataList.size())//设置完成的步数
                .reverseDraw(false)//default is true
                .setStepViewTexts(dataList)//总步骤
                .setLinePaddingProportion(0.85f)//设置indicator线与线间距的比例系数

                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));//设置StepsViewIndicator AttentionIcon


    }


}
