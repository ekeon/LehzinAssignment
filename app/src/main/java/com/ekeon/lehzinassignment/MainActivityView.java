package com.ekeon.lehzinassignment;

import com.ekeon.lehzinassignment.model.MainModel;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public interface MainActivityView {

    void successGetResult(MainModel value);

    void failGetResult(Throwable e);
}
