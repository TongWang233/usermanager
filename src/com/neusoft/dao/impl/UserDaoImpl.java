package com.neusoft.dao.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.pojo.User;
import com.neusoft.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Override
    public User login(String uname, String pwd) {
        User user = null;
        try {
            //获得连接数据库对象
            conn = DBUtils.getConn();
            //预编译sql语句
            pstmt = conn.prepareStatement("select * from user where name=? and password=?");
            //处理占位符
            pstmt.setString(1,uname);
            pstmt.setString(2,pwd);
            //执行sql语句
            rs = pstmt.executeQuery();
            //处理结果集
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return user;
    }

    @Override
    public User findbyid(int id) {
        User user = null;
        try {
            //获得连接数据库对象
            conn = DBUtils.getConn();
            //预编译sql语句
            pstmt = conn.prepareStatement("select * from user where id=? ");
            //处理占位符
            pstmt.setInt(1,id);
            //执行sql语句
            rs = pstmt.executeQuery();
            //处理结果集
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList();
        User user = null;
        try {
            conn = DBUtils.getConn();
            pstmt = conn.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return users;
    }

    @Override
    public int addUser(User user) {
        int Count = 0;
        try {
            conn = DBUtils.getConn();
            pstmt = conn.prepareStatement("insert  into user (name,age,gender,address,email,qq) values (?,?,?,?,?,?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setInt(2, user.getAge());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getQq());
            Count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return Count;
    }

    @Override
    public int delUser(int id) {
        int Count = 0;
        try {
            conn = DBUtils.getConn();
            pstmt = conn.prepareStatement("delete from user where id=?");
            pstmt.setInt(1, id);
            Count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return Count;
    }

    @Override
    public int updateUser(User user) {
        int Count = 0;
        try {
            conn = DBUtils.getConn();
            pstmt = conn.prepareStatement("update user set name=?,age=?,gender=?,address=?,email=?,qq=? where id=?");
            pstmt.setString(1, user.getUsername());
            pstmt.setInt(2, user.getAge());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getQq());
            pstmt.setInt(7, user.getId());
            Count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstmt,conn);
        }
        return Count;
    }

}
