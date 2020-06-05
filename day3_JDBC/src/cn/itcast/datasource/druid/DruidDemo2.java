package cn.itcast.datasource.druid;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cn.itcast.datasource.utils.JDBCUtils;
/*
使用心得工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /*
        完成添加操作，给表添加一条记录
         */
        Connection con=null;
        PreparedStatement ps=null;

        try {
            //1.获取连接
            con = JDBCUtils.getConnection();
            //2.定义sql
            String sql="insert into category values(null,?,?)";
            //3.定义ps对象
            ps=con.prepareStatement(sql);
            //4.赋值
            ps.setString(1,"往往");
            ps.setString(2,"娃哈哈");

            //5.执行sql
            int count=ps.executeUpdate();
            System.out.println(count);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //6.释放资源
            JDBCUtils.close(ps,con);
        }
    }
}
