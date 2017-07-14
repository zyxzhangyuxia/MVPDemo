package com.zyx.demo_mvp.presenter;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.zyx.demo_mvp.application.DemoApplication;
import com.zyx.demo_mvp.greendao.gen.UserInfoDao;
import com.zyx.demo_mvp.mode.MovieEntrty;
import com.zyx.demo_mvp.mode.UserInfo;
import com.zyx.demo_mvp.model.IMovieService;
import com.zyx.demo_mvp.model.MovieServiceGenerator;
import com.zyx.demo_mvp.presenter.presenter_interface.IDbViewUpdate;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by vectoria on 2017/7/11.
 * 数据库操作presenter
 */

public class DbOperationPresenter extends BasePresenter {
    private UserInfoDao userDao ;
    private SQLiteDatabase db;
    IDbViewUpdate iDbViewUpdate;
    private List<UserInfo> userInfoList;

    public DbOperationPresenter(IDbViewUpdate iDbViewUpdate){
        this.iDbViewUpdate = iDbViewUpdate;
        initVariable();
    }

    /**
     * 获取网络资源
     */
    public void getNetSource(){
        MovieServiceGenerator.createService(IMovieService.class)
                .getMovie(10,0)
                .map(new Func1<MovieEntrty, MovieEntrty>() {
                    @Override
                    public MovieEntrty call(MovieEntrty movieEntrty) {
                        Log.d("lcs","movieEntrty.getCount = "+movieEntrty.getCount());
                        return movieEntrty;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieEntrty>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieEntrty movieEntrty) {

                    }
                });
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

    private void notifyUi() {
        userInfoList = userDao.loadAll();
        for(int i=0;i<userInfoList.size();i++){
            Log.d("lcs",""+userInfoList.get(i).toString());
        }
        iDbViewUpdate.update(userInfoList);
    }


    @Override
    public void showMsg(String msg) {
        Toast.makeText(iDbViewUpdate.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return iDbViewUpdate.getContext();
    }

    @Override
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(iDbViewUpdate.getContext(),cls);
        iDbViewUpdate.getContext().startActivity(intent);
    }
}
