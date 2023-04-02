package com.raven.model.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection c = null;
        try {
            //Đk MySQL driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Các thông số
//            Local
            String url = "jdbc:mysql://localhost:3306/thuvien";
            String username = "root";
            String password = "";

            //Public sever
//            String url = "jdbc:mysql://db4free.net:3306/thuvien";
//            String username = "lenguyen";
//            String password = "123456789";
            //Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.err.println(mtdt.getDatabaseProductVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
