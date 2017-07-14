package com.zyx.demo_mvp.presenter;

import android.content.Context;

/**
 * Created by vectoria on 2017/7/14.
 */

public abstract class BasePresenter {

    /**
     * toast 显示消息
     * @param msg
     */
    public abstract void showMsg(String msg);

    /**
     * 获取上下文对象
     * @return
     */
    public abstract Context getContext();

    /**
     * 启动另一个activity
     * @param cls
     */
    public abstract void startActivity(Class <?> cls);
}
