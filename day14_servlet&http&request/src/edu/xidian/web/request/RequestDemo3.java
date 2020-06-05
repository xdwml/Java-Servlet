package edu.xidian.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求头名称
         String agent = request.getHeader("user-agent");

         //判断agent包含的服务器
        if(agent.contains("Chrome")){
            System.out.println("谷歌");
        }else if(agent.contains("Firefox")){
            //火狐
            System.out.println("火狐RequestDemo3RequestDemo3");
        }

    }
}
