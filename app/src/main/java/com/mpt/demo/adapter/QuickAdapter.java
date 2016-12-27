package com.mpt.demo.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mpt.demo.R;
import com.mpt.demo.model.NewsModel;

import java.util.List;

/**
 * Created by mpt on 2016/12/21.
 */

public class QuickAdapter extends BaseQuickAdapter<NewsModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean>{


    public QuickAdapter(int res,List datas) {
        super(res,datas);

    }




    @Override
    protected void convert(BaseViewHolder holder, NewsModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean item) {
        holder.setText(R.id.tv_newsTitle,item.getTitle());
        holder.setText(R.id.tv_newsDate,item.getPubDate());
        holder.setText(R.id.tv_newsChannel,item.getChannelName());
        if (item.isHavePic()){
            Glide.with(mContext).load(item.getImageurls().get(0).getUrl()).into((ImageView) holder.getView(R.id.iv_newsPic));
        }


    }
}
