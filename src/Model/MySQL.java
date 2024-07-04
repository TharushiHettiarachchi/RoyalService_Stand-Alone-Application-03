/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 *
 * @author tharu
 */
public class MySQL {

    public static Connection c;
    public static final String database = "";
    public static final String username = "root";
    public static final String password = "T200275701170h@";

    public static Statement createConnection()throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.cj.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
        }
        Statement statement = c.createStatement();
        return statement;
    }

    public static void iud(String query) {
        try {
            createConnection().executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static ResultSet search(String query) {
        try {
            ResultSet resultset = createConnection().executeQuery(query);
            return resultset;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
