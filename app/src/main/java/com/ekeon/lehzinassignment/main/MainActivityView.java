package com.ekeon.lehzinassignment.main;

import com.ekeon.lehzinassignment.model.MainModel;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public interface MainActivityView {

    void successGetResult(MainModel value);

    void successGetResultNoItem();

    void failGetResult(Throwable e);
}
