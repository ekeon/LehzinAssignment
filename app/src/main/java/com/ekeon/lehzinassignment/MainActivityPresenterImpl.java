package com.ekeon.lehzinassignment;

import android.util.Log;

import com.ekeon.lehzinassignment.api.DaumImageClient;
import com.ekeon.lehzinassignment.api.DaumImageSearchService;
import com.ekeon.lehzinassignment.model.MainModel;

import java.lang.ref.WeakReference;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ekeon on 2017. 4. 9..
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private static final String DAUM_API_KEY = "acf2f15fa4e4072b6371fef62f03a573";
    private static final String OUTPUT = "json";

    private WeakReference<MainActivityView> weakMainActivityView;

    public MainActivityPresenterImpl(MainActivityView mainActivityView) {
        weakMainActivityView = new WeakReference<>(mainActivityView);
    }

    private MainActivityView getMainActivityView(){
        return weakMainActivityView == null ? null : weakMainActivityView.get();
    }

    @Override
    public void getImageResult() {
        DaumImageSearchService daumImageSearchService = DaumImageClient.createRetrofitService(DaumImageSearchService.class);
        daumImageSearchService.getResult(DAUM_API_KEY, "hi", OUTPUT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MainModel>() {
                    @Override
                    public void onNext(MainModel value) {
                        Log.d("TAG", "value : " + value.getChannelModel().getPageCount());

                        MainActivityView mainActivityView = getMainActivityView();
                        if (mainActivityView == null) {
                            return;
                        }
                        mainActivityView.successGetResult(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "Error : " + e);

                        MainActivityView mainActivityView = getMainActivityView();
                        if (mainActivityView == null) {
                            return;
                        }
                        mainActivityView.failGetResult(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
