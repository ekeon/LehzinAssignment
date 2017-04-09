package com.ekeon.lehzinassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    @OnClick(R.id.connection_btn)
    void connectionBtnClicked(){
        Log.d("TAG", "c!ick");

        mainActivityPresenter.getImageResult();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityPresenter = new MainActivityPresenterImpl(this);
    }
}
