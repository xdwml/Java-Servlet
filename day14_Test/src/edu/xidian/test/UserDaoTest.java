package edu.xidian.test;

import edu.xidian.dao.UserDao;
import edu.xidian.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        //创建一个user对象
        User loginuser=new User();
        loginuser.setUsername("wml");
        loginuser.setPassword("1234599");//若密码不匹配会报错
        //数据库返回一个真正的对象
        UserDao userDao=new UserDao();
        User user=userDao.login(loginuser);
        System.out.println(user);

    }
}
