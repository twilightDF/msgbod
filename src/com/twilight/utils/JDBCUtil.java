package com.twilight.utils;

import java.sql.*;

public class JDBCUtil {
    static Connection conn = null;

    public static Connection getConn (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///magbod?serverTimezone=GMT","root","123456");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void free(Connection conn,PreparedStatement ps,ResultSet rs ){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ps = null;
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }

}
