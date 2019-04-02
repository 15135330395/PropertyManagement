package com.shenshi.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
	 private static Properties pro=new Properties();
	 /*静态代码块：有些代码必须在项目启动的时候就执行，
	  * 这种代码是主动执行的(当类被载入时，静态代码块被执行，且只被执行一次，
	  * 静态块常用来执行类属性的初始化)
	     静态方法：需要在项目启动的时候就初始化,在不创建对象的情况下，
	           这种代码是被动执行的（静态方法在类加载的时候就已经加载 可以用类名直接调用）。
	           两者的区别就是:静态代码块是自动执行的;
		静态方法是被调用的时候才执行的.
	 */
	 static{
		 /*load ( InputStream inStream)，从输入流中读取属性列表（键和元素对）。
			 * 通过对指定的文件（比如说上面的 test.properties 文件）
			 * 进行装载来获取该文件中的所有键 - 值对。
			 以供 getProperty ( String key) 来搜索。*/
		 try {
	pro.load(new FileReader(
			//获取当前类路劲下的config.properties的路径
			JDBCUtil.class.getClassLoader().getResource("config.properties").getPath()));
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		}
	 //创建数据库连接
	public static Connection getConnection() {
			Connection conn=null;
			try {
				// getProperty ( String key) 根据健来搜索相对应的值
				//class.forName()是运用反射的原理创建对象
				////加载Msql驱动（com.mysql.jdbc.Driver）
			Class.forName(pro.getProperty("Drivername"));
				conn=DriverManager.getConnection(
						pro.getProperty("url"), 
						pro.getProperty("username"), 
						pro.getProperty("password"));
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return conn;		
		}
		//统一关闭释放资源  注意顺序为ResultSet-Statement-Connection（必须最后关闭）
		public static void close(Connection conn,Statement state,ResultSet rs) {
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (state!=null) {
					state.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
