package edu.xidian.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用的Durid连接池
 */
public class JDBCUtils {
    //1.导入jar包
    //2.配置properties文件

    private static DataSource ds;
    //使用静态代码块加载配置
    static {
        try {
        //3.加载配置
        Properties pro=new Properties();
        //使用ClassLoader加载配置文件，输入字节输入流
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.初始化连接池对象
        ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }



    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
