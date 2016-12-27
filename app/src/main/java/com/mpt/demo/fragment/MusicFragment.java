package com.mpt.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mpt.demo.base.BaseFragmemt;
import com.orhanobut.logger.Logger;

/**
 * Created by mpt on 2016/12/20.
 */

public class MusicFragment extends BaseFragmemt {


    @Override
    protected void initView() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View initRootView(LayoutInflater inflater, ViewGroup container) {
        return null;
    }



    @Override
    public void initData() {
        Logger.i("------MusicFragment-------加载数据");
    }

    public static MusicFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("---------MusicFragment----onDestroy");
    }



}
