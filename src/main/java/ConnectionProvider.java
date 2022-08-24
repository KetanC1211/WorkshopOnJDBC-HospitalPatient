import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    static Connection con;
    public static Connection createC() {
        //Load the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create Connection
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/hospital?allowPublicKeyRetrieval=true&useSSL=false";

            con = DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
