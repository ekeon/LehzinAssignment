package com.ekeon.lehzinassignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.ekeon.lehzinassignment.model.MainModel;
import com.ekeon.lehzinassignment.viewholder.MainImageViewHolder;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public class MainActivityAdapter extends RecyclerView.Adapter {

    private final int TYPE_IMAGE = 0;
    private MainModel value;

    public void getValue(MainModel value) {
        this.value = value;
        Log.d("TAG", "setImage: " + value.getChannelModel().getItem().get(1).getImage());
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
            ((MainImageViewHolder) holder).setImage(value.getChannelModel().getItem().get(position).getImage());
        }
    }

    @Override
    public int getItemCount() {
        return value.getChannelModel().getItem().size();
    }
}
