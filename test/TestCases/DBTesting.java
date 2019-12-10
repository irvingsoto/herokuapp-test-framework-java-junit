package TestCases;


import java.sql.*;

public class DBTesting {

    public static void  main(String[] args) throws  ClassNotFoundException, SQLException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/tecgurus?serverTimezone=UTC";
               // "jdbc:mysql://10.44.181.94:3306/tecgurus";
        //"jdbc:mysql://localhost:3306/tecgurus";
        //Database Username
        String username = "root";

        //Database Password
        String password = "welcome";

        //Query to Execute
        String query = "SELECT lastname FROM employees;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results

        String lastName = null;

        if (rs.next()){
          lastName = rs.getString("lastname");
        }

        System.out.println("Result: " + lastName);

        //closing DB Connection
        con.close();
    }
}
