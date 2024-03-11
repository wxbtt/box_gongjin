package com.fongmi.android.tv_gongjin.ui.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fongmi.android.tv_gongjin.bean.Vod;

public abstract class BaseVodHolder extends RecyclerView.ViewHolder {

    public BaseVodHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void initView(Vod item);
}
