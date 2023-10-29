import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            // Initialize the connection here
            String url = "jdbc:mysql://localhost:3306/maringodatabase";
            String username = "root";
            String password = "18145C3iggy?";

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
