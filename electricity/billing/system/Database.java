package electricity.billing.system;

import java.sql.*;

public class Database {
    Connection connection;
    Statement statement;
    Database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bill_Systems","root","Anand$9847");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
