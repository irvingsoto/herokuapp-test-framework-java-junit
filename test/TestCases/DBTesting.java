package TestCases;


import java.sql.*;
import java.util.ArrayList;

public class DBTesting {

    public static void  main(String[] args) throws  ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/tecgurus?serverTimezone=UTC";

        //Database Username
        String username = "root";

        //Database Password
        String password = "welcome";

        //Query to Execute
        String query = "SELECT role FROM employees;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results

        ArrayList<String> resultList = new ArrayList();

        while (rs.next()){
          resultList.add(rs.getString("role")) ;
        }

        for (String temp : resultList) {
            System.out.println(temp);
        }

        //closing DB Connection
        con.close();
    }
}
