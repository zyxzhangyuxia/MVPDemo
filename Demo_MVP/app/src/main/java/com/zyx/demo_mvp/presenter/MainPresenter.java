package com.zyx.demo_mvp.presenter;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.zyx.demo_mvp.mode.UserLoginInfo;
import com.zyx.demo_mvp.presenter.presenter_interface.ILogin;

/**
 * Created by vectoria on 2017/7/10.
 * MainActivity所对应的P层。处理业务逻辑并与之交互
 */

public class MainPresenter extends BasePresenter {

    ILogin iLogin;

    public MainPresenter(){}

    public MainPresenter(ILogin iLogin){
        this.iLogin = iLogin;
    }

    public void login(String username,String pwd){
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)){
            iLogin.loginFailed();
            return;
        }
        if("vectoria".equals(username) && "123456".equals(pwd)){
            iLogin.loginSuccess(username,pwd);
        }
    }

    /**
     * toast信息的方法
     * @param msg
     */
    @Override
    public void showMsg(String msg){
        Toast.makeText(iLogin.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return iLogin.getContext();
    }

    @Override
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(iLogin.getContext(),cls);
        iLogin.getContext().startActivity(intent);
    }

    /**
     * 保存登录信息
     * @param userName
     * @param pwd
     */
    public void saveLoginUserInfo(String userName,String pwd){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserName(userName);
        userLoginInfo.setPwd(pwd);
    }

    /**
     * 启动另一个activity
     * @param cls
     */
//    public void startActivity(Class <?> cls){
//        Intent intent = new Intent();
//        intent.setClass(iLogin.getContext(),cls);
//        iLogin.getContext().startActivity(intent);
//    }
}
