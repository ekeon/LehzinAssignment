package com.ekeon.lehzinassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.ekeon.lehzinassignment.adapter.MainActivityAdapter;
import com.ekeon.lehzinassignment.model.MainModel;
import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    private MainActivityAdapter mainActivityAdapter;
    @BindView(R.id.rv_main) RecyclerView rvMain;

    @OnClick(R.id.connection_btn)
    void connectionBtnClicked(){
        Log.d("TAG", "c!ick");

        mainActivityPresenter.getImageResult();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityPresenter = new MainActivityPresenterImpl(this);
        mainActivityAdapter = new MainActivityAdapter();
    }

    @Override
    public void successGetResult(MainModel value) {
        mainActivityAdapter.getValue(value);

        rvMain.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvMain.setAdapter(mainActivityAdapter);

        Log.d("TAG","value :");
    }

    @Override
    public void failGetResult(Throwable e) {

    }
}
