package edu.xidian.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/d3","/dd3","/ddd3"})//三个路径都可以访问同一个Servlet
//多层路径
//@WebServlet({"/user/demo3"})
//@WebServlet({"/user/*"})
//@WebServlet({"/*"})
@WebServlet({"*.do"})

public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo3..");
    }
}
