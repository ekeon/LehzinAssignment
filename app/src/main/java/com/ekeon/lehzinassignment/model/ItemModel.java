package com.ekeon.lehzinassignment.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class ItemModel {

    @Getter @Setter
    private long pubDate;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String thumbnail;

    @Getter @Setter
    private long cp;

    @Getter @Setter
    private long height;

    @Getter @Setter
    private String link;

    @Getter @Setter
    private long width;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String cpname;
}
