package com.mpt.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.mpt.demo.MainActivity;
import com.mpt.demo.activity.NewsDetailActivity;
import com.mpt.demo.activity.PersonalActivity;
import com.mpt.demo.activity.SettingActivity;

/**
 * Created by mpt on 2016/12/21.
 *  封装UI相关的一些操作
 *
 */

public class UIHelper {

    public static void showHome(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showNewsDetail(Activity activity, String url){
        Intent intent = new Intent(activity, NewsDetailActivity.class);
        intent.putExtra("url",url);
        activity.startActivity(intent);
    }


    public static void showSettingActivity(Activity activity){
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }

    public static void showPersonalActivity(Activity activity){
        Intent intent = new Intent(activity, PersonalActivity.class);
        activity.startActivity(intent);
    }

}
