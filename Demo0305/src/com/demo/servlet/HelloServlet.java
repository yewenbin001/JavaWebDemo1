package com.demo.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author ：小兵
 * @date ：2021-03-05 9:45
 * @Description:
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println(Charset.defaultCharset());
        System.out.println("HelloServlet"+"无参构造方法");
    }

    /**
     * 初始化方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet被初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Servlet被访问
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet被销毁");
    }
}
