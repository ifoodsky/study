package com.sky.mybatis;

import com.sky.mybatis.bean.Test;

import java.sql.*;

public class SimpleExecutor implements TExecutor {
    @Override
    public <T> T query(String statement, Object parameter) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(String.format(statement, Integer.parseInt(String.valueOf(parameter))));
            ResultSet rs = pstmt.executeQuery();
            Test test = new Test();
            while (rs.next()) {
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
            return (T) test;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
