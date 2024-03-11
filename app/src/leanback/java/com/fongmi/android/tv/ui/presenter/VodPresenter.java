package com.fongmi.android.tv_gongjin.ui.presenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.leanback.widget.Presenter;

import com.fongmi.android.tv_gongjin.Product;
import com.fongmi.android.tv_gongjin.bean.Style;
import com.fongmi.android.tv_gongjin.bean.Vod;
import com.fongmi.android.tv_gongjin.databinding.AdapterVodListBinding;
import com.fongmi.android.tv_gongjin.databinding.AdapterVodOvalBinding;
import com.fongmi.android.tv_gongjin.databinding.AdapterVodRectBinding;
import com.fongmi.android.tv_gongjin.ui.base.BaseVodHolder;
import com.fongmi.android.tv_gongjin.ui.base.ViewType;
import com.fongmi.android.tv_gongjin.ui.holder.VodListHolder;
import com.fongmi.android.tv_gongjin.ui.holder.VodOvalHolder;
import com.fongmi.android.tv_gongjin.ui.holder.VodRectHolder;

public class VodPresenter extends Presenter {

    private final OnClickListener mListener;
    private final Style style;
    private final int[] size;

    public VodPresenter(OnClickListener listener) {
        this(listener, Style.rect());
    }

    public VodPresenter(OnClickListener listener, Style style) {
        this.mListener = listener;
        this.style = style;
        this.size = Product.getSpec(style);
    }

    public interface OnClickListener {

        void onItemClick(Vod item);

        boolean onLongClick(Vod item);
    }

    @Override
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        switch (style.getViewType()) {
            case ViewType.LIST:
                return new VodListHolder(AdapterVodListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), mListener);
            case ViewType.OVAL:
                return new VodOvalHolder(AdapterVodOvalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), mListener).size(size);
            default:
                return new VodRectHolder(AdapterVodRectBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), mListener).size(size);
        }
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object object) {
        ((BaseVodHolder) viewHolder).initView((Vod) object);
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
}