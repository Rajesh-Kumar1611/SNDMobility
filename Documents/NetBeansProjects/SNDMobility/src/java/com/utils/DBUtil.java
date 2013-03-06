/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rajesh
 */
public class DBUtil {

    static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sndmobility";
    static final String USERNAME = "root";
    static final String PASSWORD = "rajesh";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn;
        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    public static void closeConnection(Connection con) throws SQLException {
        con.close();

    }
}
