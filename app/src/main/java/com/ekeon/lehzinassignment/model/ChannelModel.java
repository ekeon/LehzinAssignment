package com.ekeon.lehzinassignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class ChannelModel {

    @Getter @Setter @SerializedName("result")
    private int result;

    @Getter @Setter @SerializedName("pageCount")
    private long pageCount;

    @Getter @Setter @SerializedName("title")
    private String title;

    @Getter @Setter @SerializedName("totalCount")
    private long totalCount;

    @Getter @Setter @SerializedName("description")
    private String description;

    @Getter @Setter @SerializedName("item")
    private ArrayList<ItemModel> item;

    @Getter @Setter @SerializedName("lastBuildDate")
    private String lastBuildDate;

    @Getter @Setter @SerializedName("link")
    private String link;

    @Getter @Setter @SerializedName("generator")
    private String generator;
}
