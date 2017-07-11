package com.zyx.demo_mvp.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zyx.demo_mvp.greendao.gen.DaoMaster;
import com.zyx.demo_mvp.greendao.gen.DaoSession;

/**
 * Created by vectoria on 2017/7/11.
 */

public class DemoApplication extends Application {

    public SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    static DemoApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        setupDatabase();
    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user.db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取数据库实例
     * @return
     */
    public SQLiteDatabase getDb(){
        return db;
    }

    /**
     * 获取DaoMaster对象
     * @return
     */
    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    /**
     * 获取DaoSession对象
     * @return
     */
    public DaoSession getDaoSession(){
        return daoSession;
    }

    public static DemoApplication getApplication() {
        return application;
    }
}
