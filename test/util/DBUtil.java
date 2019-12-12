package util;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {

    public ArrayList<String> sqlResult (String dataToQuery, String table) throws  ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/tecgurus?serverTimezone=UTC";

        ArrayList<String> result = new ArrayList();

        String username = "root";
        String password = "welcome";

        String query = "SELECT " + dataToQuery +" FROM " + table +";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        while (rs.next()){
            result.add(rs.getString(dataToQuery)) ;
        }
        con.close();

        return result;

    }

    public static void main(String[] args) throws  ClassNotFoundException, SQLException{

        DBUtil o = new DBUtil();
        System.out.println(o.sqlResult("firstname", "employees"));
        if(o.sqlResult("firstname","employees").contains("irving")){
            System.out.println("Si se encontro el dato");
        }
        else System.out.println("No se encontro el dato");


    }
}
