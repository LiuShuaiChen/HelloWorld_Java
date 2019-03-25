package com.alice.service;

import com.alice.bean.UserBean;

import java.util.List;

public interface IUser {

    UserBean addUser();

    int delUser(int id);

    List<UserBean> getList();

}
