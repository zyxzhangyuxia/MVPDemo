package com.zyx.demo_mvp.mode;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vectoria on 2017/7/11.
 * 数据库实体类
 *
 */

@Entity
public class UserInfo {
    @Id(autoincrement = true)
    private Long id;
    private int age;
    private String name;
    private String tel;

    @Generated(hash = 1140809130)
    public UserInfo(Long id, int age, String name, String tel) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.tel = tel;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
