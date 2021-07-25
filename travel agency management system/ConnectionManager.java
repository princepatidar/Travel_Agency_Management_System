import java.sql.*;
public class ConnectionManager
{
    private static String url = "jdbc:mysql://localhost:3306/travel";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "root";
    static Connection con=null;

    public static void getConnect() {
        try {
                Class.forName(driverName);
                con = DriverManager.getConnection(url,username,password);
        } catch (Exception ex) { ex.printStackTrace(); }

    }
}  