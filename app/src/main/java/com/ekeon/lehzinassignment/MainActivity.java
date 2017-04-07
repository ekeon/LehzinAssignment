package com.ekeon.lehzinassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ekeon.lehzinassignment.api.DaumImageClient;
import com.ekeon.lehzinassignment.api.DaumImageSearchService;
import com.ekeon.lehzinassignment.model.MainModel;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String DAUM_API_KEY = "acf2f15fa4e4072b6371fef62f03a573";
    private static final String OUTPUT = "json";

    @OnClick(R.id.connection_btn)
    void connectionBtnClicked(){
        Log.d("TAG", "c!ick");
        connect();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void connect() {
        DaumImageSearchService daumImageSearchService = DaumImageClient.createRetrofitService(DaumImageSearchService.class);
        daumImageSearchService.getResult(DAUM_API_KEY, "hi", OUTPUT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MainModel>() {
                    @Override
                    public void onNext(MainModel value) {
                        Log.d("TAG", "value : " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "Error : " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
