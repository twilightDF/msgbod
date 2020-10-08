package com.twilight.dao;

import com.twilight.pojo.User;
import com.twilight.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addUser(User user)
    {
        try{
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement("insert into user values(null,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.free(conn,ps,null);
        }
    }

    @Override
    public User queryUserByUsernameAndPassword(String username,String password) {
        User user = new User();
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement("select * from user where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //获取结果
            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.free(conn, ps, rs);
        }
        return user;
    }

}

