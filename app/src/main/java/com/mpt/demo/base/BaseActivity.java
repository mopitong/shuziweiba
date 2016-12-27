package com.mpt.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mpt.demo.R;

import static com.orhanobut.logger.Logger.init;

/**
 * Created by mpt on 2016/12/20.
 *
 *
 */

public class BaseActivity extends AppCompatActivity{
    protected Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        mContext = BaseActivity.this;

    }



    protected void showToast(String msg){
       Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
