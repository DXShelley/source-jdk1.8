package demo.org.apache.commons.dbutils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 *  使用DBCP实现数据库的连接池
 *  连接池配置,自定义类,
 *  最基本四项完整
 *  对于数据库连接池其他配置,自定义
 * @author vanguard
 *
 */
public class JDBCPoolUtils {
    //创建出BasicDataSource类对象
    private static BasicDataSource datasource = new BasicDataSource();

    //静态代码块，对BasicDataSource类进行配置
    static {
        //数据库连接信息，必须的
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/stdb");
        datasource.setUsername("root");
        datasource.setPassword("root");
        //对象连接池中的连接数量配置，可选
        datasource.setInitialSize(10);//初始化的连接数
        datasource.setMaxTotal(8);
        datasource.setMaxIdle(5);//最大空闲数
        datasource.setMinIdle(2);//最小空闲数
    }
    /**
     * 返回BasicDataSource类对象
     * @return
     */
    public static DataSource getDataSource() {
        return datasource;
    }
}
