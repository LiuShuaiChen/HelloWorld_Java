package com.alice.service.impl;

import com.alice.bean.UserBean;
import com.alice.service.IUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements IUser {


    @Override
    public UserBean addUser() {
        return null;
    }

    @Override
    public int delUser(int id) {
        return 0;
    }

    @Override
    public List<UserBean> getList() {
        return null;
    }


    public void around(){

    }
}
