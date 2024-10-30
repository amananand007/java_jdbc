package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {

    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";

    public static String URL="jdbc:mysql://localhost:3306/studentdb";

    public static String PASSWORD="root";

    public static String USERNAME="root";

    public static void main( String[] args )
    {
        try {

            // load driver
            Class.forName(LOAD_DRIVER);

            // making connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            // create statement
            Statement statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );
            // create query
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.last();
            System.out.println("Fetching last row");
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));

            System.out.println();

            resultSet.first();
            System.out.println("Fetching last row");
            System.out.println("Id " + resultSet.getInt("id"));
            System.out.println("Name " + resultSet.getString("Name"));

            connection.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
