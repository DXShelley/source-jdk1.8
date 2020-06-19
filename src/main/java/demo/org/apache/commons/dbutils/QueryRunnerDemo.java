package demo.org.apache.commons.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * QueryRunner类
 * update(Connection conn, String sql, Object... params)
 * 实现表中数据的增、删、改
 * @author vanguard
 *
 */
public class QueryRunnerDemo {
    //获取数据库连接
    private static Connection conn = JDBCUtils.getConnection();

    public static void main(String[] args) throws SQLException {
        insert();
//        delete();
//        update();
    }


    /**
     * 使用Q    ueryRunner类中的update方法，实现添加数据
     * @throws SQLException
     */
    public static void insert() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO person(name,age,sex) VALUES(?,?,?)";
        //将三个?占位符的实际参数写在数组中
        Object[] params = {"小猪", 22, "m"};

        Object[][] paramList = new Object[5][];
        for (int i = 0; i < 5; i++) {
            paramList[i] = new Object[]{"小猪" + i, 33, "m"};

        }
        //调用QueryRunner类的方法update执行SQL语句
//        int row = qr.update(conn, sql, params);
        int[] row = qr.batch(conn, sql, paramList);
        System.out.println(row);
//        DbUtils.closeQuietly(conn);
    }
    /**
     *  使用QueryRunner类中的update方法，实现添加数据
     * @throws SQLException
     */
    public static void delete() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        String sql = "DELETE FROM person WHERE name=?";
        //调用QueryRunner类的方法update执行SQL语句
        int row = qr.update(conn, sql, "小猪");
        System.out.println(row);
//        DbUtils.closeQuietly(conn);
    }

    /**
     * 使用QueryRunner类中的update方法，实现更新数据
     * @throws SQLException
     */
    public static void update() throws SQLException {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //定义更新的sql语句
        String sql = "UPDATE person SET name=?,age=?,sex=? WHERE name=?";
        ////将四个?占位符的实际参数写在数组中
        Object[] params = {"小狗", 21, "f", "小猪"};
        ////调用QueryRunner类的方法update执行SQL语句
        int row = qr.update(conn, sql, params);
        System.out.println(row);
//        DbUtils.closeQuietly(conn);
    }

}
