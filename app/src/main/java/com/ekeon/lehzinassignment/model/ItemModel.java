package com.ekeon.lehzinassignment.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class ItemModel {

    @Getter @Setter @SerializedName("pubDate")
    private long pubDate;

    @Getter @Setter @SerializedName("title")
    private String title;

    @Getter @Setter @SerializedName("thumbnail")
    private String thumbnail;

    @Getter @Setter @SerializedName("cp")
    private String cp;

    @Getter @Setter @SerializedName("height")
    private int height;

    @Getter @Setter @SerializedName("link")
    private String link;

    @Getter @Setter @SerializedName("width")
    private int width;

    @Getter @Setter @SerializedName("image")
    private String image;

    @Getter @Setter @SerializedName("cpname")
    private String cpname;
}
