package edu.xidian.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求头名称referer
         String referer = request.getHeader("referer");
        System.out.println(referer);

         //防止盗链
        if(referer !=null) {
            if (referer.contains("/day14")) {
                //正常访问
                System.out.println("播放电影");
                response.setContentType("text/heml;charset=utf-8");
                response.getWriter().write("播放电影");
            }else{
                //盗链
                System.out.println("想看电影吗？来优酷吧");

                response.setContentType("text/heml;charset=utf-8");
                response.getWriter().write("想看电影吗？来优酷吧");
            }
        }

    }
}
