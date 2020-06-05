package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象,使用默认配置
        //DataSource ds=new ComboPooledDataSource();
        //1.不使用默认配置的数据库连接池
        DataSource ds=new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象
        for (int i =1; i <=10; i++) {
            Connection conn=ds.getConnection();
            //3.打印
            System.out.println("连接对象："+i+":"+conn);
        }

    }
}
