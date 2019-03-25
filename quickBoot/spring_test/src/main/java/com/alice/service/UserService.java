package com.alice.service;

import com.alice.bean.UserBean;

import java.util.List;

public interface UserService {


    UserBean addUser();

    int delUser(int id);

    List<UserBean> getList();
}
