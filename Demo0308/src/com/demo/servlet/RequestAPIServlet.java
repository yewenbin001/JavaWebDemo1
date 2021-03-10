package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

/**
 * @author ：小兵
 * @date ：2021-03-08 9:49
 * @Description:
 */
@WebServlet("/requestAPI01")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求资源路径URI
        System.out.println("URI=" + req.getRequestURI());
        //2.获取请求的统一资源定位URL
        System.out.println("URI=" + req.getRequestURL());
        //3.获取客户端的IP地址
        System.out.println("客户端IP地址=" + req.getRemoteHost());
        System.out.println("客户端getRemoteAddr=" + req.getRemoteAddr());
        //4.获取请求头
        System.out.println("请求头=" + req.getHeader("Cookie"));
        //5.获取请求方式GET或POST
        System.out.println("请求方式：" + req.getMethod());
        //获取名为username的value值
        String username = req.getParameter("username");
        System.out.println("username:"+username);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取名为username的value值
        String username = req.getParameter("username");
        //获取名为password的value值
        String password = req.getParameter("password");
        //获取名为hobby的value值，用字符串数组接收
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("hobbys:"+ Arrays.asList(hobbys));

//        req.setAttribute();
    }
}
