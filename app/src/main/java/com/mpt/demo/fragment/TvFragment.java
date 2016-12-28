package com.mpt.demo.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.mpt.demo.MainActivity;
import com.mpt.demo.R;
import com.mpt.demo.adapter.GridViewAdapter;
import com.mpt.demo.adapter.HorizontalCardviewAdapter;
import com.mpt.demo.adapter.ViewPagerAdapter;
import com.mpt.demo.base.BaseFragmemt;
import com.mpt.demo.model.HorizontalCardViewModel;
import com.mpt.demo.utils.DividerItemDecoration;
import com.mpt.demo.utils.GlideImageLoader;
import com.mpt.demo.utils.UIHelper;
import com.orhanobut.logger.Logger;
import com.rd.PageIndicatorView;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.data;
import static android.R.attr.tabStripLeft;
import static android.R.attr.value;

/**
 * Created by mpt on 2016/12/20.
 */

public class TvFragment extends BaseFragmemt {


    @BindView(R.id.rel_recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;


    private RecyclerView mHorizontalview;

    private View headview;
    private List<String> imageList = new ArrayList<>();
    private LayoutInflater inflater;
    private List<View> mPagerList;

    private String[] titles = {"公交查询", "快递查询", "酒店住宿", "休闲娱乐", "外卖", "自助餐"};
    /**
     * 总的页数
     */
    private int pageCount;
    /**
     * 每一页显示的个数
     */
    private int pageSize = 4;
    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;

    @Override
    protected void initView() {

        headview = LayoutInflater.from(mContext).inflate(R.layout.header_tvfragment, null);
        Banner mBanner = (Banner) headview.findViewById(R.id.banner);
        if (mBanner != null) {
            mBanner.setImageLoader(new GlideImageLoader());
            imageList.add("http://imgsrc.baidu.com/baike/pic/item/8ad4b31c8701a18bb114ffa3982f07082938fe5b.jpg");
            imageList.add("http://img2.imgtn.bdimg.com/it/u=3858321188,4047822346&fm=11&gp=0.jpg");
            imageList.add("http://img5.imgtn.bdimg.com/it/u=1664676372,2608449173&fm=11&gp=0.jpg");
            mBanner.setImages(imageList);
            mBanner.start();
        }


        mHorizontalview = (RecyclerView) headview.findViewById(R.id.rel_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHorizontalview.setLayoutManager(linearLayoutManager);


        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));


        //带指示器的viewpager
        final ViewPager mPager = (ViewPager) headview.findViewById(R.id.vp_gridview);
        inflater = LayoutInflater.from(getActivity());
        //总的页数=总数/每页数量，并取整
        pageCount = (int) Math.ceil(titles.length * 1.0 / pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++) {
            // 每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
            gridView.setAdapter(new GridViewAdapter(getActivity(), titles, i, pageSize));
            mPagerList.add(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pos = position + curIndex * pageSize;
                    switch (pos){
                        case 0:
                            UIHelper.showBusSearchActivity(getActivity());
                       break;
                        case 1:
                            UIHelper.showKuaidiActivity(getActivity());
                            break;

                       default:
                       break;
                    }




                }
            });
        }

        mPager.setAdapter(new ViewPagerAdapter(mPagerList));
        PageIndicatorView pageIndicatorView = (PageIndicatorView) headview.findViewById(R.id.pageIndicatorView);

        pageIndicatorView.setCount(pageCount);


        pageIndicatorView.setViewPager(mPager);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View initRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }


    @Override
    public void initData() {
       List<HorizontalCardViewModel> datas = new ArrayList<>();
        HorizontalCardViewModel data1 = new HorizontalCardViewModel();
        data1.setCard_name("第一个");
        HorizontalCardViewModel data2 = new HorizontalCardViewModel();
        data2.setCard_name("第二个");
        HorizontalCardViewModel data3 = new HorizontalCardViewModel();
        data3.setCard_name("第三个");
        HorizontalCardViewModel data4 = new HorizontalCardViewModel();
        data4.setCard_name("第四个");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);

        mHorizontalview.setAdapter(new HorizontalCardviewAdapter(R.layout.item_horizontalrelcycleview,datas));

        HorizontalCardviewAdapter adapter = new HorizontalCardviewAdapter(R.layout.item_horizontalrelcycleview,datas);
        mRecyclerview.setAdapter(adapter);
        adapter.addHeaderView(headview);



    }

    public static TvFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        TvFragment fragment = new TvFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("---------TvFragment----onDestroy");
    }



}
