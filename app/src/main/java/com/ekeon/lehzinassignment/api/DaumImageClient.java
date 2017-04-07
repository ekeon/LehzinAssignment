package com.ekeon.lehzinassignment.api;

import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ekeon on 2017. 4. 7..
 */

public class DaumImageClient {

    private static final String DAUM_URL = "https://apis.daum.net/";

    public static <T> T createRetrofitService(final Class<T> clazz) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DAUM_URL)
                .client(createOkHttpClient())
                .callbackExecutor(Executors.newCachedThreadPool())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        T service = retrofit.create(clazz);

        return service;
    }

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        return builder.build();
    }
}
