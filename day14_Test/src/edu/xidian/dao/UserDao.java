package edu.xidian.dao;

import edu.xidian.domain.User;
import edu.xidian.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库中User表的类
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());



    /**
     * 登录方法
     * @param loginuser 只有用户名和密码
     * @return 包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginuser){
        //如果用户名密码正确，不抛出异常，若错误抛出异常返回null
        try {
            //1.编写sql
            String sql = "select * from user where username=? and password=?";
            //2.调用query方法，将数据封装成一个对象
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(), loginuser.getPassword());

            return user;
        }catch (DataAccessException e){
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
