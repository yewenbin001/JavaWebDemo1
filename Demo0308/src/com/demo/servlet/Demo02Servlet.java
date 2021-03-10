package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：小兵
 * @date ：2021-03-08 21:33
 * @Description:
 */
@WebServlet(name ="Demo02Servlet" ,urlPatterns = "/demo02.do" )
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出存在request中的key01
        System.out.println(req.getAttribute("key01"));

    }
}
