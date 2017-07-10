package com.zyx.demo_mvp.presenter;

import android.content.Context;


/**
 * Created by vectoria on 2017/7/10.
 * p 与 v 交互的接口
 */

public interface ILogin {
    Context getContext();
    void loginSuccess(String userName,String pwd);
    void loginFailed();
}
