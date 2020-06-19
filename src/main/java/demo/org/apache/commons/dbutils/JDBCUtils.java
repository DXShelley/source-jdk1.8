package demo.org.apache.commons.dbutils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    public static Connection getConnection() {

        String driverClassName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@//192.168.70.57:1521/orcl";
        String userName = "casic_dev";
        String password = "casic_$dev";

        Connection connection = null;
        try {
            //注册方式一：
            //Class.forName(driverClassName);
            // 注册方式二：
            Driver driver =  new oracle.jdbc.OracleDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
