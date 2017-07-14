package com.zyx.demo_mvp.presenter.presenter_interface;

import android.content.Context;


/**
 * Created by vectoria on 2017/7/10.
 * p 与 v 交互的接口
 */

public interface ILogin extends IBase{

    @Override
    Context getContext();

    /**
     * 用户登录成功之后回调的方法
     * @param userName
     * @param pwd
     */
    void loginSuccess(String userName,String pwd);

    /**
     * 用户登录失败之后回调的方法
     */
    void loginFailed();
}
