package com.pancm.service;


import com.pancm.bean.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean delUser(int id);

    List<User> findAll();

    User findByName(String name);
}
