package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：小兵
 * @date ：2021-03-08 21:25
 * @Description: 请求转发
 */
@WebServlet(name = "Demo01Servlet",urlPatterns = "/demo01.do")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置一个键，值存储在request
        req.setAttribute("key01","柜台1的公章");
        //转发到路径为demo02的servlet中
        req.getRequestDispatcher("/demo02.do").forward(req,resp);
    }
}
