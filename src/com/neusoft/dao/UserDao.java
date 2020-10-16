package com.neusoft.dao;

import com.neusoft.pojo.User;

import java.util.List;

public interface UserDao {

    //login
    public User login(String uname, String pwd);

    public User findbyid(int id);

    public List<User> findAll();

    public int addUser(User user);

    public int delUser(int  id);

    public int updateUser(User  user);



}
