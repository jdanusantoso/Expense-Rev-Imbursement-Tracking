package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionUTIL {

    private static JDBCConnectionUTIL util;

    private static Properties props = new Properties();

    private JDBCConnectionUTIL() {}

    public static JDBCConnectionUTIL getInstance() {
        if(util == null) {
            return new JDBCConnectionUTIL();
        }
        return util;
    }

    public Connection getConnectionThroughPropFile() {
        //This will look in our src/main/resources for a jdbc.properties file and load it in for us as a byte stream

        Connection con = null;

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream in = classLoader.getResourceAsStream("jdbc.properties");

            String url="";
            String password="";
            String username="";



            props.load(in);

            url = props.getProperty("url");
            System.out.println("url retrieved: " + url);
            username = props.getProperty("username");
            System.out.println("username retrieved: " + username);
            password = props.getProperty("password");
            System.out.println("password retrieved: " + password);


            //After we load our url, username, and password from the file, we want to attempt making a connection
            con = DriverManager.getConnection(url, username, password);

        } catch (IOException e) {
            //e.printStackTrace();
        } catch (SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }

    //public Connection getConnectionFromENV() {

    public static Connection getConnectionThroughENV()  {
        String url = System.getenv("DB_URL");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        Connection con = null;

        try {
            url = url + "/expense_management1";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return con;
    }








}