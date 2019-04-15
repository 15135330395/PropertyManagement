package com.web.util;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: JdbcUtil
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

   private static String driverClassName="com.mysql.jdbc.Driver";
   private static String url="jdbc:mysql://localhost:3306/test";
   private static String username="root";
   private static String password="1234";
 static Connection connection;

   public static Connection getConnection(){
       try {
            Class.forName(driverClassName);
            connection=DriverManager.getConnection(url, username, password);

       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return connection;
   }

public void close(){
       if(connection!=null){
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
}

}
