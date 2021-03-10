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

/**
 * @author ：小兵
 * @date ：2021-03-07 10:16
 * @Description:
 */
@WebServlet("/login1")
public class LoginServlet1 extends HttpServlet {
    ArrayList<User> users = null;
    ServletContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟数据库
        users = new ArrayList<>();
        users.add(new User("admin", "123", null, 0));
        users.add(new User("user1", "456", null, 0));
        users.add(new User("user2", "789", null, 0));
        users.add(new User("user3", "111", null, 0));
        //取出ServletContext，设置他的 totalCount 值为0s
        context=config.getServletContext();
        context.setAttribute("totalCount",0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("passwored");
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        resp.setContentType("text/html;charset=utf-8");
        Writer writer=resp.getWriter();
        if (users.contains(user)){
            writer.write("<h1>"+username+"登录成功</h1>");
            context.setAttribute("totalCount",(int)context.getAttribute("totalCount")+1);
            writer.write("<h1>第"+context.getAttribute("totalCount")+"位登录系统</h1>");
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).equals(user)){
                    user=users.get(i);
                    user.setLoginCount(user.getLoginCount()+1);
                    writer.write("<h1>"+user.getLoginCount()+"</h1>");
                }
            }
        }else {
            writer.write("<h1>账号密码错误</h1>");
        }
    }
}
