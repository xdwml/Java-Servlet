package edu.xidian.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo8888访问了。。。");
        //转发到Demo9路径
        /*RequestDispatcher requestDispatcher=request.getRequestDispatcher("/RequestDemo9");
        requestDispatcher.forward(request,response);*///合二为一
        //存储数据到request域中
        request.setAttribute("msg","hello");

        request.getRequestDispatcher("/RequestDemo9").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
