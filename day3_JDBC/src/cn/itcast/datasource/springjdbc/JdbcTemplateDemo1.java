package cn.itcast.datasource.springjdbc;

import cn.itcast.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql="update category set cname='大爷' where cid=7";
        int count=template.update(sql);
        System.out.println(count);
    }
}
