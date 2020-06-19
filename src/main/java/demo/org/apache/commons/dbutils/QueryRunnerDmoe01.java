package demo.org.apache.commons.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 使用QueryRunner类中的
 * query(Connection conn, String sql, ResultSetHandler<T> rsh,
 *                         Object... params)
 * 完成对数据的查询操作
 * ResultSetHandler结果集处理类 8中处理结果集的方式
 *  ArrayHandler    将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值
 *  ArrayListHandler    将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。
 *  BeanHandler    将结果集中第一条记录封装到一个指定的javaBean中。
 *  BeanListHandler    将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
 *  ColumnListHandler    将结果集中指定的列的字段值，封装到一个List集合中
 *  ScalarHandler    它是用于单数据。例如select count(*) from 表操作。
 *  MapHandler    将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
 *  MapListHandler    将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合
 * @author vanguard
 *
 */
public class QueryRunnerDmoe01 {
    private static Connection conn = JDBCUtils.getConnection();

    public static void main(String[] args) throws SQLException {
        //arrayHandler();
        //arrayListHandler();
        //beanHandler();
        //beanListHandler();
        //columnListHandler();
        //scalarHandler();
        //mapHandler();
        mapListHandler();
    }

    /**
     * 结果集处理的第八种方式MapListHandler
     * 将结果集的每一行结果封装到Map集合中，Key 列名，Value 该列的数据
     * 将Map集合放到List集合中
     * @throws SQLException
     */
    public static void mapListHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        List<Map<String, Object>> list = qr.query(conn, sql, new MapListHandler());
        //遍历List集合
        for(Map<String, Object> map : list) {
            for(String row : map.keySet()) {
                System.out.print(row + ":" + map.get(row) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 结果集处理的第七种方式MapHandler
     * 将结果集的第一行数据封装到Map集合中 Key 列名 Value 该列数据
     * @throws SQLException
     */
    public static void mapHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        Map<String, Object> map = qr.query(conn, sql, new MapHandler());
        for(String row : map.keySet()) {
            System.out.print(row + ":" + map.get(row) + "  ");
        }
    }

    /**
     * 结果集处理的第六种方式ScalarHandler
     * 它用于单数据，对于查询后只有一个结果
     * @throws SQLException
     */
    public static void scalarHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT COUNT(*) FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        BigDecimal count = qr.query(conn, sql, new ScalarHandler<BigDecimal>());
        System.out.println(count);
    }

    /**
     * 结果集处理的第五种方式ColumnListHandler
     * 将结果集中指定列的字段值封装到list集合中
     * @throws SQLException
     */
    public static void columnListHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        List<String> list = qr.query(conn, sql, new ColumnListHandler<String>("name"));
        for(String name : list) {
            System.out.println(name);
        }
    }

    /**
     * 结果集处理的第四种方式BeanListHandler
     * 将结果集中每一条数据封装到JavaBean对象中
     * 将这些JavaBean对象放到list集合中
     * @throws SQLException
     */
    public static void beanListHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        List<Person> list = qr.query(conn, sql, new BeanListHandler<Person>(Person.class));
        //遍历list集合
        for(Person s : list) {
            System.out.println(s);
        }
    }

    /**
     * 结果集处理的第三种方式BeanHandler
     * 将结果集中的第一条数据封装到JavaBean对象中
     * 注意：被封装成数据到JavaBean对象，Person类中必须有空参构造
     * @throws SQLException
     */
    public static void beanHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        Person s = qr.query(conn, sql, new BeanHandler<Person>(Person.class));
        System.out.println(s);
    }

    /**
     * 结果集处理的第二种方式ArrayListHandler
     * 将结果集的每一行封装到Object[]数组中
     * 将这些数组放到list集合中
     * @throws SQLException
     */
    public static void arrayListHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
        for(Object[] objs : list) {
            for(Object obj : objs) {
                System.out.print(obj + "\t\t");
            }
            System.out.println();
        }
    }

    /**
     * 结果集处理的第一种方式ArrayHandler
     * 将结果集的第一行封装到Object[]数组中
     * @throws SQLException
     */
    public static void arrayHandler() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义查询的sql语句
        String sql = "SELECT * FROM person";
        //调用query()执行查询操作，传递连接对象，SQL语句，结果处理类方式的实现类
        Object[] objects = qr.query(conn, sql, new ArrayHandler());
        //遍历数组
        for(Object obj : objects) {
            System.out.print(obj + "  ");
        }
    }
}

