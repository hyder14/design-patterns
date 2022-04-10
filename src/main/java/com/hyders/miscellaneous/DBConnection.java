package com.hyders.miscellaneous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan({"com.hyders.miscellaneous.config"})
public class DBConnection {

    private ConnectionPoolDataSource connectionPoolDataSource = null;

    @Autowired
    private static Environment environment;

    @Value("${jdbc.url}")
    String jdbUrl;


    @Value("${jdbc.driverClassName}")
    String driverClassName;

    @Value("${jdbc.user}")
    String userName;

    @Value("${jdbc.pass}")
    String password;

    private static Connection dbConnection = null;


    @Autowired
    DataSource restDataSource;


//    @Autowired
    public DBConnection() {

    }

    private void getConnection() {

        try {
/*
            Class.forName(environment.getProperty("jdbc.driverClassName"));
            String url = environment.getProperty("jdbc.url");
            String user = environment.getProperty("jdbc.user");
            String pass = environment.getProperty("jdbc.pass");
*/
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false";
            String user = "root";
            String pass = "admin";



            dbConnection = DriverManager.getConnection(url,user,pass);

//            dbConnection = restDataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Bean
    public Connection dbConnection() {
        getConnection();
        return dbConnection;
    }


    public static void main(String[] args) {

        DBConnection dbConn = new DBConnection();

        try {

            dbConn.getConnection();
            System.out.println("Connection is open " + !dbConnection.isClosed());

            dbConnection.close();
            Thread.sleep(3000);
            System.out.println("Connection is closed " + dbConnection.isClosed());

        } catch (Exception e) {
            e.printStackTrace();
        }




        try {
            if (dbConnection.isClosed()) {
                //DBConnection dbConnection = new DBConnection();
                System.out.println("Opening a new connection");
                dbConn.getConnection();

                System.out.println("Connection is open " + !dbConnection.isClosed());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dbConnection!=null){
                try{
                    dbConnection.close();
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }

            }
        }


    }




}
