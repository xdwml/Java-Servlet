package cn.itcast.datasource.springjdbc;

import cn.itcast.datasource.utils.JDBCUtils;
import cn.itcast.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //Junit单元测试，可以让方法独立执行


    //1.获取JDBCTemplate对象
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 1.修改1号数据的salary为10000
     */
    @Test
    public void test1(){

        //2.定义sql语句
        String sql = "update emp.emp set salary=10000 where id=1";
        //3.执行sql
        int c=template.update(sql);
        System.out.println("执行成功1:"+c);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){

        //2.定义sql语句
        String sql = "INSERT into emp.emp(name,salary) values(?,?)";
        //3.执行sql
        int c=template.update(sql,"赵龙",700);
        System.out.println("执行成功2:"+c);
    }
    /**
     * 3.删除一条记录
     */
    @Test
    public void test3(){

        //2.定义sql语句
        String sql = "DELETE from emp.emp where id=?";
        //3.执行sql
        int c=template.update(sql,5);
        System.out.println("执行成功3:"+c);
    }

    /**
     * 4.查询id为1的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        //2.定义sql语句
        String sql = "select * from emp.emp where id=?";
        //3.执行sql
        Map<String,Object> map=template.queryForMap(sql,2);
        System.out.println("执行成功4:"+map);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5(){
        //2.定义sql语句
        String sql = "select * from emp.emp";
        //3.执行sql
        List<Map<String,Object>> list= (List) template.queryForList(sql);
        for (Map<String,Object> stringObjectMap:list) {
            System.out.println("执行成功5:"+stringObjectMap);
        }
    }
    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6(){
        //2.定义sql语句
        String sql = "select * from emp.emp";
        //3.执行sql
        List<Emp> list= template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                Date entry_date = rs.getDate("entry_date");
                double salary = rs.getDouble("salary");
                int resume_text = rs.getInt("resume_text");
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setBirthday(birthday);
                emp.setEntry_date(entry_date);
                emp.setSalary(salary);
                emp.setResume_text(resume_text);

                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */

    @Test
    public void test6_2(){
        String sql = "select * from emp.emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数
     */

    @Test
    public void test7(){
        String sql = "select count(id) from emp.emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }


}
