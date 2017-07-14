package com.zyx.demo_mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.zyx.demo_mvp.R;
import com.zyx.demo_mvp.mode.UserInfo;
import com.zyx.demo_mvp.presenter.DbOperationPresenter;
import com.zyx.demo_mvp.presenter.presenter_interface.IDbViewUpdate;
import com.zyx.demo_mvp.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vectoria on 2017/7/11.
 * 数据库操作UI
 */

public class DbActivity extends AppCompatActivity implements View.OnClickListener, IDbViewUpdate {

    @Bind(R.id.btn_add)
    Button btn_add;

    @Bind(R.id.btn_delete)
    Button btn_delete;

    @Bind(R.id.btn_update)
    Button btn_update;

    @Bind(R.id.btn_query_condition)
    Button btn_query_condition;

    @Bind(R.id.btn_query_all)
    Button btn_query_all;

    @Bind(R.id.listview_db_data)
    ListView listview_db_data;

    @Bind(R.id.tv_no_data)
    TextView tv_no_data;

    @Bind(R.id.btn_net)
    Button btn_net;

    DbOperationPresenter dbOperationPresenter;
    ListAdapter listAdapter;
    List<UserInfo> userInfoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        ButterKnife.bind(this);
        initVariable();
        initViewListener();
        dbOperationPresenter.queryAllData();
    }

    /**
     * 注册监听事件
     */
    private void initViewListener(){
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query_condition.setOnClickListener(this);
        btn_query_all.setOnClickListener(this);
        btn_net.setOnClickListener(this);
    }

    /**
     * 变量初始化的方法
     */
    private void initVariable(){
        dbOperationPresenter = new DbOperationPresenter(this);
        userInfoList = new ArrayList<>();
        if(userInfoList.size() == 0){
            switchUi(false);
            return;
        }
        switchUi(true);
        listAdapter = new ListAdapter(userInfoList,this);
        listview_db_data.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                dbOperationPresenter.addData();
                break;
            case R.id.btn_delete:
                dbOperationPresenter.deleteData();
                break;
            case R.id.btn_update:
                dbOperationPresenter.updateData();
                break;
            case R.id.btn_query_all:
                dbOperationPresenter.queryAllData();
                break;
            case R.id.btn_query_condition:
                dbOperationPresenter.QueryByCondition();
                break;
            case R.id.btn_net:
                dbOperationPresenter.startActivity(TestRxActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void update(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
        if(userInfoList.size() == 0){
            switchUi(false);
            return;
        }
        switchUi(true);
        listAdapter = new ListAdapter(userInfoList,this);
        listview_db_data.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    private void switchUi(boolean isShowListView){
        if(isShowListView){
            listview_db_data.setVisibility(View.VISIBLE);
            tv_no_data.setVisibility(View.GONE);
        }else{
            listview_db_data.setVisibility(View.GONE);
            tv_no_data.setVisibility(View.VISIBLE);
        }
    }
}
