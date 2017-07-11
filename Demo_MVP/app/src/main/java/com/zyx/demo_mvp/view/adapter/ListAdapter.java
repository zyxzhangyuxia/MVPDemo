package com.zyx.demo_mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyx.demo_mvp.R;
import com.zyx.demo_mvp.mode.UserInfo;

import java.util.List;

/**
 * Created by vectoria on 2017/7/11.
 */

public class ListAdapter extends BaseAdapter {

    List<UserInfo> userInfoList;
    Context context;

    private TextView tv_id,tv_name,tv_age,tv_tel;


    public ListAdapter(List<UserInfo> userInfoList, Context context){
        this.userInfoList = userInfoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return userInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_listview_layout,viewGroup,false);
        tv_id = view.findViewById(R.id.tv_id);
        tv_name = view.findViewById(R.id.tv_name);
        tv_age = view.findViewById(R.id.tv_age);
        tv_tel = view.findViewById(R.id.tv_tel);
        tv_id.setText(String.valueOf(userInfoList.get(i).getId()));
        tv_name.setText(userInfoList.get(i).getName());
        tv_age.setText(String.valueOf(userInfoList.get(i).getAge()));
        tv_tel.setText(userInfoList.get(i).getTel());
        return view;
    }
}
