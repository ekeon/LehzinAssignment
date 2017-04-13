package com.ekeon.lehzinassignment.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ekeon.lehzinassignment.model.MainModel;
import com.ekeon.lehzinassignment.main.viewholder.MainImageViewHolder;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public class MainActivityAdapter extends RecyclerView.Adapter {

    private final static int TYPE_IMAGE = 0;
    private MainModel value;
    private int recyclerViewWidth = 0;

    private void valueClear() {
        this.value = new MainModel();
        notifyDataSetChanged();
    }

    public void getValue(MainModel value) {
        valueClear();
        this.value = value;
    }

    public void getRecyclerViewWidth(int recyclerViewWidth) {
        this.recyclerViewWidth = recyclerViewWidth;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        Context context = parent.getContext();

        switch (viewType) {
            case TYPE_IMAGE:
                viewHolder = MainImageViewHolder.newInstance(context);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainImageViewHolder) {
            ((MainImageViewHolder) holder).bind(value.getChannelModel().getItem().get(position), recyclerViewWidth);
        }
    }

    @Override
    public int getItemCount() {
        return value.getChannelModel().getItem().size();
    }
}
