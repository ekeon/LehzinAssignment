package com.ekeon.lehzinassignment.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ekeon.lehzinassignment.R;
import com.ekeon.lehzinassignment.main.adapter.MainActivityAdapter;
import com.ekeon.lehzinassignment.model.MainModel;
import com.ekeon.lehzinassignment.util.NetworkUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    private MainActivityAdapter mainActivityAdapter;

    private Timer timer = new Timer();

    @BindString(R.string.network_state_check) String netWorkState;
    @BindString(R.string.query_not) String queryNot;
    @BindString(R.string.result_not) String resultNot;
    @BindString(R.string.error) String error;

    @BindView(R.id.rv_main) RecyclerView rvMain;
    @BindView(R.id.et_text_field) EditText etTextField;
    @BindView(R.id.tv_error) TextView tvError;

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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (TextUtils.isEmpty("" + etTextField.getText().toString())) {
                                // TODO: 2017. 4. 11. 토스트나 검색어를 입력해주세요 문구.
                                setErrorView(queryNot);
                                return;
                            }

                            if (NetworkUtil.getConnectivityStatus(getApplicationContext()) == 0) {
                                setErrorView(netWorkState);
                                return;
                            }

                            rvMain.setVisibility(View.VISIBLE);
                            tvError.setVisibility(View.GONE);
                            mainActivityPresenter.getImageResult(etTextField.getText().toString());
                        }
                    });
                }
            }, 1000);
        }
    };

    private void setErrorView(String errorText) {
            rvMain.setVisibility(View.GONE);
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(errorText);
    }

    @Override
    public void successGetResult(MainModel value) {
        mainActivityAdapter.getValue(value);
        mainActivityAdapter.getRecyclerViewWidth(rvMain.getWidth());

        rvMain.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvMain.setAdapter(mainActivityAdapter);
    }

    @Override
    public void successGetResultNoItem() {
        setErrorView(resultNot);
    }

    @Override
    public void failGetResult(Throwable e) {
        setErrorView(error);
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
    }
}
