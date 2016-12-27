package com.mpt.demo.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.mpt.demo.R;
import com.mpt.demo.adapter.QuickAdapter;
import com.mpt.demo.model.NewsModel;
import com.mpt.demo.base.BaseFragmemt;
import com.mpt.demo.utils.DividerItemDecoration;
import com.mpt.demo.utils.GlideImageLoader;
import com.mpt.demo.utils.UIHelper;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

import static android.media.CamcorderProfile.get;

/**
 * Created by mpt on 2016/12/20.
 */

public class HomeFragment extends BaseFragmemt implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rel_recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private QuickAdapter mAdapter;
    private List<String> imageList = new ArrayList<>();
    private List<NewsModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean> datas;
    private List<NewsModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean> datasMore;
    private View bannerView;
    private int page = 1;
    private int state;//标识  进入应用第一次获取0，刷新1,加载更多2

    public static HomeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View initRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Logger.i("-----------initRootView");
        return view;
    }


    @Override
    protected void initView() {
        Logger.i("-----------initView");
        mSwiperefreshlayout.setOnRefreshListener(this);
        bannerView = LayoutInflater.from(mContext).inflate(R.layout.mainbanner, null);
        Banner mBanner = (Banner) bannerView.findViewById(R.id.banner);
        if (mBanner != null) {
            mBanner.setImageLoader(new GlideImageLoader());
            imageList.add("http://imgsrc.baidu.com/baike/pic/item/8ad4b31c8701a18bb114ffa3982f07082938fe5b.jpg");
            imageList.add("http://img2.imgtn.bdimg.com/it/u=3858321188,4047822346&fm=11&gp=0.jpg");
            imageList.add("http://img5.imgtn.bdimg.com/it/u=1664676372,2608449173&fm=11&gp=0.jpg");
            mBanner.setImages(imageList);
            mBanner.start();
        }

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        datasMore = new ArrayList<>();
    }


    @Override
    public void initData() {
        Logger.i("------HomeFragment-------加载数据");
        // 这句话是为了，第一次进入页面的时候显示加载进度条
        if (state == 0) {
            mSwiperefreshlayout.setProgressViewOffset(false, 0, (int) TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                            .getDisplayMetrics()));
            mSwiperefreshlayout.setRefreshing(true);
        }
        OkHttpUtils.post()
                .url("http://route.showapi.com/109-35")
                .addParams("showapi_appid", "29029")
                .addParams("showapi_sign", "7f44c1576c634333bcf5c4657e0e5aec")
                .addParams("page", String.valueOf(page))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showToast("网络不给力");

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        NewsModel root = new Gson().fromJson(response, NewsModel.class);
                        if (root.getShowapi_res_code() == 0) {
                            Logger.i("获取数据返回" + response);
                            datas = root.getShowapi_res_body().getPagebean().getContentlist();

                            switch (state) {
                                case 0:
                                    bindDataToView();
                                    datasMore.addAll(datas);
                                    break;
                                case 1:
                                    mAdapter.setNewData(datas);
                                    datasMore.clear();
                                    datasMore.addAll(datas);
                                    mAdapter.notifyDataSetChanged();
                                    mSwiperefreshlayout.setRefreshing(false);
                                    break;
                                case 2:
                                    mAdapter.addData(datas);
                                    datasMore.addAll(datas);
                                    Logger.i("--------data.size()--"+datasMore.size());
                                    mAdapter.notifyDataChangedAfterLoadMore(true);
                                    mSwiperefreshlayout.setRefreshing(false);
                                    page++;
                                    break;


                            }


                        }else {
                            showToast("出了点问题(⊙o⊙)");
                            mSwiperefreshlayout.setRefreshing(false);
                        }

                    }

                });

    }

    private void bindDataToView() {
        Logger.i("------------bindDataToView");
        mAdapter = new QuickAdapter(R.layout.item_homefragment, datas);
        mAdapter.openLoadMore(20,true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                state = 2;
                initData();
            }
        });
        mRecyclerview.setAdapter(mAdapter);
        mSwiperefreshlayout.setRefreshing(false);
        mAdapter.addHeaderView(bannerView);

        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {

                UIHelper.showNewsDetail(getActivity(), datasMore.get(i).getLink());
            }
        });

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("---------HomeFragment----onDestroy");
    }


    @Override
    public void onRefresh() {
        state = 1;
        initData();
    }




}
