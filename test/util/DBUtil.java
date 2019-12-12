package util;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {

    public ArrayList<String> sqlResult (String dataToQuery, String table) {

        String dbUrl = "jdbc:mysql://localhost:3306/databasename?serverTimezone=UTC";
        String username = "root";
        String password = "welcome";
        String query = "SELECT " + dataToQuery +" FROM " + table +";";

        ArrayList<String> result = new ArrayList();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(dbUrl,username,password);
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);

            while (rs.next()){ result.add(rs.getString(dataToQuery)) ; }

            con.close();

        } catch (ClassNotFoundException e ){ System.out.println("Not Possible to load JDBC Driver " + e); }
          catch (SQLException e){ System.out.println("Not Possible to connect to database " + e); }

        return result;
    }

    public static void main(String[] args) {

        DBUtil dbUtil = new DBUtil();

        System.out.println(dbUtil.sqlResult("first_name", "employees"));

        if(dbUtil.sqlResult("first_name","employees").contains("Irving")) System.out.println("Si se encontro el dato");
        else System.out.println("No se encontro el dato");

    }
}
