package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description JdbcUtil
 * @Author 项目组
 * @CreateTime 2019-03-26 14:47
 */
public class JdbcUtil {
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://172.16.4.33:3306/property_management?serverTimezone=GMT%2B8";
    private static String user = "root";
    private static String password = "1234";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}