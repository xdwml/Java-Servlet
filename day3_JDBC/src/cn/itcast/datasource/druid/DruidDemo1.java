package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
Druid演示
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入包
        //2.定义配置文件
        //3.加载配置文件
        Properties pro=new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        //3.获取数据库连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //2.获取连接对象
        for (int i =1; i <=10; i++) {
            Connection conn=ds.getConnection();
            //3.打印
            System.out.println("连接对象："+i+":"+conn);
        }

    }
}
