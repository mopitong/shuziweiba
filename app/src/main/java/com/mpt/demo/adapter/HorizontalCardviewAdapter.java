package com.mpt.demo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mpt.demo.R;
import com.mpt.demo.model.HorizontalCardViewModel;

import java.util.List;

/**
 * Created by mpt on 2016/12/26.
 */

public class HorizontalCardviewAdapter extends BaseQuickAdapter<HorizontalCardViewModel>{
    public HorizontalCardviewAdapter(int layoutResId, List<HorizontalCardViewModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, HorizontalCardViewModel item) {
        holder.setText(R.id.tv_card,item.getCard_name());

    }
}
