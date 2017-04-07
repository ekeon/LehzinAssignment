package com.ekeon.lehzinassignment.api;

import com.ekeon.lehzinassignment.model.MainModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public interface DaumImageSearchService {

    @GET("search/image")
    Observable<MainModel> getResult(
            @Query("apikey") String apikey,
            @Query("q") String question,
            @Query("output") String output);
}
