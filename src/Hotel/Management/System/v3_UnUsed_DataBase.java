package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class v3_UnUsed_DataBase {
    Connection connection;
    Statement statement;
    public v3_UnUsed_DataBase(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS","root","12345678");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
