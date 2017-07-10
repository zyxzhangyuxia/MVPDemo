package com.zyx.demo_mvp.mode;

/**
 * Created by vectoria on 2017/7/10.
 * 保存数据的javabean
 * userName:用户名
 * pwd：密码
 */

public class UserLoginInfo {
    private String userName;
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
