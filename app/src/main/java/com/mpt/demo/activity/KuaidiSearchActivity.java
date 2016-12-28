package com.mpt.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.mpt.demo.R;
import com.mpt.demo.base.BaseActivity;
import com.mpt.demo.model.KuaidiModel;
import com.mpt.demo.ui.StateButton;
import com.mpt.demo.utils.UIHelper;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by mpt on 2016/12/27.
 */

public class KuaidiSearchActivity extends BaseActivity {


    @BindView(R.id.tl_title)
    Toolbar mToolbar;
    @BindView(R.id.ed_num)
    MaterialEditText mNum;
    @BindView(R.id.bt_search)
    StateButton mSearch;
    @BindView(R.id.tv_kuaidi)
    TextView mKuaidi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuaidisearch);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {
        mToolbar.setTitle("快递查询");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }




    @OnClick(R.id.bt_search)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_search:
                if (TextUtils.isEmpty(mNum.getText().toString())) {
                    showToast("请输入快递单号");
                } else {
                    loadData();
                }


                break;

            default:
                break;
        }


    }

    /*查询快递*/
    private void loadData() {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .content("查询中...")
                .progress(true, 0);
        final MaterialDialog dialog = builder.build();
        dialog.show();
        OkHttpUtils.post()
                .url("http://route.showapi.com/64-19")
                .addParams("showapi_appid", "29029")
                .addParams("showapi_sign", "7f44c1576c634333bcf5c4657e0e5aec")
                .addParams("com","auto")
                .addParams("nu",mNum.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("--------" + e.getMessage());
                        showToast("网络有问题(⊙o⊙)");
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("---------查询快递返回--" + response);
                        KuaidiModel dataRoot = new Gson().fromJson(response,KuaidiModel.class);

                        if (dataRoot.getShowapi_res_code() == 0) {
                           if (dataRoot.getShowapi_res_body().getData().size()!=0){
                            ArrayList<String> dataList = new ArrayList<String>();
                            List<KuaidiModel.ShowapiResBodyBean.DataBean> dataBeanList = dataRoot.getShowapi_res_body().getData();
                            for (int i = 0; i <dataBeanList.size() ; i++) {

                                dataList.add(dataBeanList.get(i).getContext());

                            }

                            UIHelper.showKuaidiDetailActivity(KuaidiSearchActivity.this,dataRoot.getShowapi_res_body().getExpTextName(),dataList);




                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }

                           }
                        } else {

                            showToast("暂无相关信息");
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }
                        }


                    }
                });

    }


}
