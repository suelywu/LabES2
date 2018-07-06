package api.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGetter {
    private Connection connection;

    public ConnectionGetter() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/labes_marcenaria_1?" +
                    "user=root&password=MyPassword&serverTimezone=UTC");
            System.out.println("Conectado... ");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Classe nao encontrada");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
