package com.fongmi.android.gongjin.ui.holder;

import androidx.annotation.NonNull;

import com.fongmi.android.gongjin.Product;
import com.fongmi.android.gongjin.bean.Episode;
import com.fongmi.android.gongjin.databinding.AdapterEpisodeHoriBinding;
import com.fongmi.android.gongjin.ui.adapter.EpisodeAdapter;
import com.fongmi.android.gongjin.ui.base.BaseEpisodeHolder;

public class EpisodeHoriHolder extends BaseEpisodeHolder {

    private final EpisodeAdapter.OnClickListener listener;
    private final AdapterEpisodeHoriBinding binding;

    public EpisodeHoriHolder(@NonNull AdapterEpisodeHoriBinding binding, EpisodeAdapter.OnClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    @Override
    public void initView(Episode item) {
        binding.text.setMaxEms(Product.getEms());
        binding.text.setSelected(item.isSelected());
        binding.text.setActivated(item.isActivated());
        binding.text.setText(item.getDesc().concat(item.getName()));
        binding.text.setOnClickListener(v -> listener.onItemClick(item));
    }
}
