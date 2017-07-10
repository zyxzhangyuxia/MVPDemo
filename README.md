# mvp 与 mvc 相比，最大的不同和优点是：

* MVP架构中，view层与Model层不能直接交互，通过presenter层来完成
* MVP架构中把activity看做是view层，这就大大减少了activity的工作量
* MVP中P层与V层的交互，是通过接口来实现的

# 代码中view层与model层通过P来交互的说明：
   用户登录成功之后，保存登录信息
   
     view层：调用P层的方法
   
      @Override
    public void loginSuccess(String userName, String pwd) {
        mainPresenter.showMsg(getResources().getString(R.string.login_success));
        mainPresenter.saveLoginUserInfo(userName,pwd);
    }
    
    P 层：
    
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
    
    Model层：
    
    public class UserLoginInfo {
    private String userName;
    private String pwd;
    ....
    }
