package edu.xidian.servlet;

import edu.xidian.dao.UserDao;
import edu.xidian.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        /*//2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装user对象
        User loginuser =new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
        //使用beanutils简化步骤
        //2.获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //3.1创建User对象
        User loginuser=new User();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用UserDao的login方法
        UserDao userDao=new UserDao();
        User user=userDao.login(loginuser);//查询到的user

        //5.判断user
        if(user==null){
            //登录失败，转发到失败页面
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            //登录成功

            //1.存储数据
            request.setAttribute("user",user);
            //2.转发
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
