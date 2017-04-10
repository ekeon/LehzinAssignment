package com.ekeon.lehzinassignment.viewholder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.lehzinassignment.R;
import com.ekeon.lehzinassignment.model.ItemModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

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

    public void bind(ItemModel itemModel, int recyclerViewWidth) {
        if (itemModel.getImage() == null) {
            return;
        }
        //height resize = width resize * orignal height / orignal width;
        int heightResize = (recyclerViewWidth * itemModel.getHeight()) / itemModel.getWidth();

        sdvImage.getLayoutParams().width = recyclerViewWidth;
        sdvImage.getLayoutParams().height = heightResize;

        sdvImage.setImageURI(Uri.parse("" + itemModel.getImage()));
    }


}
