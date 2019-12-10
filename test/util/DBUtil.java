package util;

import java.sql.*;

public class DBUtil {

    public String sqlResult (String dataToQuery, String table) throws  ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/tecgurus?serverTimezone=UTC";
        String result = null;

        //Database Username
        String username = "root";

        //Database Password
        String password = "welcome";

        //Query to Execute
        String query = "SELECT " + dataToQuery +" FROM " + table +";";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        if (rs.next()){
            result = rs.getString(dataToQuery);
        }

        //closing DB Connection
        con.close();

        return result;

    }

    public static void main(String[] args) throws  ClassNotFoundException, SQLException{

        DBUtil o = new DBUtil();
        System.out.println(o.sqlResult("firstname", "employees"));


    }
}
