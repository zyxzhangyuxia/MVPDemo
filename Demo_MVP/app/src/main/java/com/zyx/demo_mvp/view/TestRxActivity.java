package com.zyx.demo_mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zyx.demo_mvp.R;
import com.zyx.demo_mvp.presenter.TestRxPresenter;
import com.zyx.demo_mvp.presenter.presenter_interface.ITestRx;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vectoria on 2017/7/14.
 */

public class TestRxActivity extends AppCompatActivity implements ITestRx {

    @Bind(R.id.btn_getPngFile)
    Button btn_getPngFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testrx);
        ButterKnife.bind(this);
        init();
    }

    private  void init(){
        final TestRxPresenter testRxPresenter = new TestRxPresenter(this);
        btn_getPngFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRxPresenter.test();
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }
}
