package com.mpt.demo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mpt.demo.adapter.MainFragmentPagerAdapter;
import com.mpt.demo.base.BaseActivity;
import com.mpt.demo.fragment.HomeFragment;
import com.mpt.demo.fragment.MusicFragment;
import com.mpt.demo.fragment.TvFragment;
import com.mpt.demo.utils.UIHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, Toolbar.OnMenuItemClickListener, ViewPager.OnPageChangeListener {


    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.tl_title)
    Toolbar mToolbar;
    @BindView(R.id.activity_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.vp_viewpager)
    ViewPager mViewpager;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    private ArrayList<Fragment> fragments;
    private HomeFragment mHomeFragment;
    private MusicFragment mMusicFragment;
    private TvFragment mTvFragment;
    private ActionBarDrawerToggle mDrawerToggle;
    private AnimationDrawable mAnimationDrawable;
    private ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVIew();
    }

    private void initVIew() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "电视"))
                .setFirstSelectedPosition(0)
                .initialise();
        fragments = getFragments();
        mViewpager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        mViewpager.setCurrentItem(0);//设置当前显示标签页为第一页
        mViewpager.setOnPageChangeListener(this);
        mBottomNavigationBar.setTabSelectedListener(this);

        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.start();

        mToolbar.setTitle("数字尾巴");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setOnMenuItemClickListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mAnimationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mAnimationDrawable.start();
            }
        };

        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        View headView = mNavigationView.getHeaderView(0);
        mLogo = (ImageView)headView.findViewById(R.id.iv_logo);
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

        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               UIHelper.showPersonalActivity(MainActivity.this);
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.setting:
//                        showToast("设置");

                        UIHelper.showSettingActivity(MainActivity.this);

                   break;
                    case R.id.item_three:

                        /*普通风格*/
//                        new MaterialDialog.Builder(mContext)
//                                .content("暂无附近的人")
//                                .positiveText("确定")
//                                .show();

                       /*权限风格*/
//                        new MaterialDialog.Builder(mContext)
//
//                                .title("该app需要拍照权限")
//                                .positiveText("允许")
//                                .negativeText("拒绝")
//                                .onAny(new MaterialDialog.SingleButtonCallback() {
//                                    @Override
//                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                        showToast("Prompt checked? " + dialog.isPromptCheckBoxChecked());
//                                    }
//                                })
//                                .checkBoxPromptRes(R.string.dont_ask_again, false, null)
//                                .show();

                        /*带有圆形进度条*/
                        new MaterialDialog.Builder(mContext)
                                .content("加载中...")
                                .progress(true, 0)
                                .show();

                        break;

                   default:
                   break;
                }



                return true;
            }
        });

    }



    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(MusicFragment.newInstance("Music"));
        fragments.add(TvFragment.newInstance("TV"));
        return fragments;
    }


    @Override
    public void onTabSelected(int position) {
        mViewpager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {


    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
//        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                showToast("设置");
                break;
            case R.id.setting:
                showToast("设置");
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        mBottomNavigationBar.selectTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
