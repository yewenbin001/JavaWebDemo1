package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：小兵
 * @date ：2021-03-08 15:30
 * @Description:
 */
@WebServlet(name = "Demo03Servlet", urlPatterns = "/demo03.do")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用doPost方法
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向第一种方案
        //设置响应状态码302，表示重定向（原网址已经搬迁）
        resp.setStatus(302);
        //设置响应头，设置要定向的地址
        //设置访问站外网址（或）站内资源
        //resp.setHeader("Location","http://www.baidu.com");
        // resp.sendRedirect("http://localhost:8080/Demo0308/fileDownload.do");
        //重定向第二种方案
        resp.sendRedirect("http://www.baidu.com");
    }
}
