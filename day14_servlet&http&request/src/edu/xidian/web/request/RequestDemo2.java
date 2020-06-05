package edu.xidian.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()){
            //根据名称获取请求头的值
            String name = headerNames.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+"--"+value);
        }
    }
}
