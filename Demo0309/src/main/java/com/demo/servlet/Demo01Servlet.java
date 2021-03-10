package com.demo.servlet;


import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author ：小兵
 * @date ：2021-03-09 9:25
 * @Description:
 */
@WebServlet(name = "Demo01Servlet", urlPatterns = "/demo01.do")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title > response回传的Html页面 </title >");
        writer.write("</head >");
        writer.write("<body >");
        writer.write("<h1>现在的时间式：" + new Date() + "</h1>");
        writer.write("</body >");
        writer.write("</html >");
    }

    @Test
    public void test(){}
}
