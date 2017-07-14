package com.zyx.demo_mvp.presenter.presenter_interface;

/**
 * Created by vectoria on 2017/7/11.
 */

import android.content.Context;

import com.zyx.demo_mvp.mode.UserInfo;

import java.util.List;

/**
 *
 */
public interface IDbViewUpdate extends IBase{

    @Override
    Context getContext();

    void update(List<UserInfo> userInfoList);
}
