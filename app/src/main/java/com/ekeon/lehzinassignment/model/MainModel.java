package com.ekeon.lehzinassignment.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class MainModel {

    @Getter @Setter @SerializedName("channel")
    private ChannelModel channelModel;
}
