package com.ekeon.lehzinassignment.viewholder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.lehzinassignment.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public class MainImageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.sdv_image) SimpleDraweeView sdvImage;

    public static MainImageViewHolder newInstance(Context context) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.main_imageholder, null);
        return new MainImageViewHolder(itemView);
    }

    public MainImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setImage(String uri) {
        if (uri == null) {
            return;
        }
        sdvImage.setImageURI(Uri.parse("" + uri));
    }


}
