package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class v3_new_database {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/hotelMs";
    private static final String username ="root";
    private static final String password="12345678";
    public Connection connection;
    v3_new_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            connection = DriverManager.getConnection(url,username,password);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
