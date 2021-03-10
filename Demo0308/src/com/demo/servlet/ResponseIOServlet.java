package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：小兵
 * @date ：2021-03-08 21:55
 * @Description:
 */
@WebServlet(name = "ResponseIOServlet", urlPatterns = "/text.do")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应的乱码解决
        //方案一：
        //设置服务器字符集为UTF-8
        response.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        //方案二：推荐使用
        //它会同时设置服务器和客户端都使用UTF-8字符集编码
        //该方法一定要在获取流对象之前使用才有效
        response.setContentType("text/html;charset=UTF-8");
        //创建一个输出流
        PrintWriter writer = response.getWriter();
        writer.write("<h1>响应的字符串内容</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
