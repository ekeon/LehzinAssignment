package com.ekeon.lehzinassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.ekeon.lehzinassignment.adapter.MainActivityAdapter;
import com.ekeon.lehzinassignment.model.MainModel;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    private MainActivityAdapter mainActivityAdapter;

    private Timer timer;

    @BindView(R.id.rv_main) RecyclerView rvMain;
    @BindView(R.id.et_text_field) EditText etTextField;

    @OnClick(R.id.connection_btn)
    void connectionBtnClicked(){
        mainActivityPresenter.getImageResult(etTextField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityPresenter = new MainActivityPresenterImpl(this);
        mainActivityAdapter = new MainActivityAdapter();

        etTextField.addTextChangedListener(textwatcher);
    }

    private TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d("TAG", "onTextChanged: hoi");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (timer == null) {
                return;
            }

            timer.cancel();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.d("TAG", "afterTextChanged: hai");
                }
            }, 1000);
        }
    };

    @Override
    public void successGetResult(MainModel value) {
        mainActivityAdapter.getValue(value);
        mainActivityAdapter.getRecyclerViewWidth(rvMain.getWidth());

        rvMain.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvMain.setAdapter(mainActivityAdapter);
    }

    @Override
    public void successGetResultNoItem() {
        // TODO: 2017. 4. 10. 검색결과가 없어요 토스트.
    }

    @Override
    public void failGetResult(Throwable e) {
        // TODO: 2017. 4. 10. 에러에열.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
