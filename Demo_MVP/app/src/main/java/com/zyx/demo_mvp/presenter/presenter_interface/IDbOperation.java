package com.zyx.demo_mvp.presenter.presenter_interface;

import com.zyx.demo_mvp.mode.UserInfo;

import java.util.List;

/**
 * Created by vectoria on 2017/7/11.
 * 数据库操作接口,与Modle交互
 */

public interface IDbOperation extends IBase{

    /**
     * 插入数据
     */
    void addData();

    /**
     * 删除数据
     */
    void deleteData();

    /**
     * 更新数据
     */
    void updateData();

    /**
     * 查询所有数据
     * @return
     */
    void queryAllData();

    /**
     * 按条件查询
     * @return
     */
    void QueryByCondition();
}
