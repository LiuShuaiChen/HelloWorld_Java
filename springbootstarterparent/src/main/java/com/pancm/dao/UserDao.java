package com.pancm.dao;

import com.pancm.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert(" Insert into t_user(id,name,age) values (#{id}, #{name}, #{age})")
    void addUser(User user);

    @Update(" Update t_user set name=#{name}, age=#{age} where id=#{id}")
    void updateUser(User user);

    @Delete(" Delete from t_user where id = #{id}")
    void delUser(int id);

    @Select(" Select id,name,age from t_user where name = #{userName}")
    User findByName(@Param("userName") String userName);

    @Select(" Select id,name,age from t_user")
    List<User> findAll();
}
