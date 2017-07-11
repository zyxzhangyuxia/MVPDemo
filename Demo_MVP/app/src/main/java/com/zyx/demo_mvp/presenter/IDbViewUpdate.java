package com.zyx.demo_mvp.presenter;

/**
 * Created by vectoria on 2017/7/11.
 */

import android.content.Context;

import com.zyx.demo_mvp.mode.UserInfo;

import java.util.List;

/**
 *
 */
public interface IDbViewUpdate {
    /**
     * 获取上下文对象
     * @return
     */
    Context getContext();
    void update(List<UserInfo> userInfoList);
}
