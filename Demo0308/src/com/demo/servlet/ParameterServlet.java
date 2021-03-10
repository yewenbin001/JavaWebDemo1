package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：小兵
 * @date ：2021-03-08 21:50
 * @Description:
 */
@WebServlet(name = "ParameterServlet",urlPatterns = "/ParameterServlet")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        //doGet请求的中文乱码解决
        //1.先以iso8859-1进行编码
        //2.再以utf-8进行编码
        username = new String(username.getBytes("iso-8859-1"), "UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求的中文乱码解决
        //设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        resp.setCharacterEncoding("UTF-8");
    }
}
