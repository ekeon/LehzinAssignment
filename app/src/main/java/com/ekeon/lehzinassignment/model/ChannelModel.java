package com.ekeon.lehzinassignment.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class ChannelModel {

    @Getter @Setter
    private long result;

    @Getter @Setter
    private long pageCount;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private long totalCount;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private ArrayList<ItemModel> item;

    @Getter @Setter
    private String lastBuildDate;

    @Getter @Setter
    private String link;

    @Getter @Setter
    private String generator;
}
