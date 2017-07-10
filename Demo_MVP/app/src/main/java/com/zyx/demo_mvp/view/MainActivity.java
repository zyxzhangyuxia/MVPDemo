package com.zyx.demo_mvp.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zyx.demo_mvp.R;
import com.zyx.demo_mvp.mode.UserLoginInfo;
import com.zyx.demo_mvp.presenter.ILogin;
import com.zyx.demo_mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements ILogin{

    private EditText et_username;
    private EditText et_pwd;
    private Button btn_login;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        initView();
    }

    /**
     * xml中的控件初始化
     */
    private void initView(){
        et_username = (EditText) findViewById(R.id.et_username);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = et_username.getText().toString().trim();
                String pwd = et_pwd.getText().toString().trim();
                mainPresenter.login(userName,pwd);
            }
        });
    }

    /**
     * 变量初始化的方法
     */
    private void initVariable(){
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loginSuccess(String userName, String pwd) {
        mainPresenter.showMsg(getResources().getString(R.string.login_success));
        mainPresenter.saveLoginUserInfo(userName,pwd);
    }

    @Override
    public void loginFailed() {
        mainPresenter.showMsg(getResources().getString(R.string.err_tip));
    }
}
