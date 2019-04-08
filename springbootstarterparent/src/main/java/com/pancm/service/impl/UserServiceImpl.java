package com.pancm.service.impl;

import com.pancm.bean.User;
import com.pancm.dao.UserDao;
import com.pancm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean addUser(User user) {

        try {
            userDao.addUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateUser(User user) {


        try {
            userDao.updateUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delUser(int id) {


        try {
            userDao.delUser(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
