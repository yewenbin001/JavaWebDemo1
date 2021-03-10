package com.demo.servlet;

import com.demo.bean.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author ：小兵
 * @date ：2021-03-07 13:37
 * @Description:
 */
@WebServlet("/login1")
public class LoginServlet1 extends HttpServlet {
    //用户集合
    ArrayList<User> users=null;
    //ServletContext创建一个全局唯一的域对象，所有servlet都可以访问
    ServletContext context=null;
    /**
     * Servlet第一次被调用，自动加载init方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟用户集合
        users = new ArrayList<>();
        users.add(new User("admin", "123", null, 0));
        users.add(new User("user1", "456", null, 0));
        users.add(new User("user2", "789", null, 0));
        users.add(new User("user3", "111", null, 0));
        //取出ServletContext
         context=config.getServletContext();
        //ServletContext设置一个名 totalCount的属性 值为0
        context.setAttribute("totalCount",0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user =new User(username,password);
        resp.setContentType("text/html;charset=utf-8");
        Writer writer = resp.getWriter();
        if (users.contains(user)){
            writer.write("<h1>"+username+"登录成功</h1>");
            context.setAttribute("totalCount",(int)context.getAttribute("totalCount")+1);
            writer.write("<h1>第"+context.getAttribute("totalCount")+"位登录系统</h1>");
            int a =users.indexOf(user);
            user=users.get(a);
            user.setLoginCount(user.getLoginCount()+1);
            writer.write("<h1>第"+user.getLoginCount()+"次登录系统</h1>");
            if (user.getLastLoginDate()!=null){
                writer.write("<h1>上次登录系统的时间"+user.getLoginCount()+"</h1>");
            }
            user.setLastLoginDate(new Date());
        }else{
            writer.write("<h1>用户密码错误</h1>");
        }
    }
}
