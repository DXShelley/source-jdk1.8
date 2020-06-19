package demo.org.apache.commons.dbutils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池
 * 连接池jar包中定义好了一个类DataSource
 * 实现该类数据源的规范接口 javax.sql.DataSource
 * @author vanguard
 *
 */
public class DataSourceDemo {
    public static void main(String[] args) {
        //创建DataSource类接口的实现类对象
        BasicDataSource datasource = new BasicDataSource();
        //连接数据库的四个基本信息可以通过setXXX方法设置
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/mybase");
        datasource.setUsername("root");
        datasource.setPassword("root");

        //调用对象的方法获取数据库连接
        try {
            Connection conn = datasource.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }
}