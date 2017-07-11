package com.zyx.demo_mvp.presenter;


import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.zyx.demo_mvp.application.DemoApplication;
import com.zyx.demo_mvp.greendao.gen.UserInfoDao;
import com.zyx.demo_mvp.mode.UserInfo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by vectoria on 2017/7/11.
 * 数据库操作presenter
 */

public class DbOperationPresenter {
    private UserInfoDao userDao ;
    private SQLiteDatabase db;
    IDbViewUpdate iDbViewUpdate;
    private List<UserInfo> userInfoList;

    public DbOperationPresenter(IDbViewUpdate iDbViewUpdate){
        this.iDbViewUpdate = iDbViewUpdate;
        initVariable();
    }

    public void addData() {
        UserInfo userInfo = new UserInfo(null,23,"vectoria","18302876279");
        userDao.insert(userInfo);
        notifyUi();
        showMsg("插入成功");
    }

    public void deleteData() {
        userDao.deleteAll();
        notifyUi();
        showMsg("删除全部数据");
    }

    public void updateData() {
        UserInfo user = userDao.queryBuilder()
                .where(UserInfoDao.Properties.Age.eq(23)).build().unique();
        if (user != null){
            user.setAge(25);
            userDao.update(user);
            showMsg("更新完成");
        }
        notifyUi();
    }

    public void queryAllData() {
        notifyUi();
    }

    public void QueryByCondition() {
        // 通过构建 QueryBuilder 来实现查询功能
        QueryBuilder<UserInfo> queryBuilder = userDao.queryBuilder().where(UserInfoDao.Properties.Name.eq("vectoria"));
        // .list() 方法会返回实体类集合
        List<UserInfo> userInfoList = queryBuilder.list();
        iDbViewUpdate.update(userInfoList);
    }

    /**
     * 变量初始化
     */
    private void initVariable(){
        db = DemoApplication.getApplication().getDb();
        userDao = DemoApplication.getApplication().getDaoSession().getUserInfoDao();
    }

    private void showMsg(String msg){
        Toast.makeText(iDbViewUpdate.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    private void notifyUi() {
        userInfoList = userDao.loadAll();
        for(int i=0;i<userInfoList.size();i++){
            Log.d("lcs",""+userInfoList.get(i).toString());
        }
        iDbViewUpdate.update(userInfoList);
    }
}
