package com.demo.servlet;

import com.demo.bean.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author ：小兵
 * @date ：2021-03-07 14:51
 * @Description:
 */
public class LoginServlet4 extends HttpServlet {
    ArrayList<User> users=null;
    ServletContext context=null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        users = new ArrayList<>();
        users.add(new User("admin", "123", null, 0));
        users.add(new User("user1", "456", null, 0));
        users.add(new User("user2", "789", null, 0));
        users.add(new User("user3", "111", null, 0));
        context=config.getServletContext();
        context.setAttribute("totalCount",0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user= new User(username,password);
        resp.setContentType("text/html;charset=utf-8");
        Writer wirter=resp.getWriter();
        if (users.contains(user)){
            wirter.write("<h1>登录成功"+username+"</h1>");
            context.setAttribute("totalCount",(int)context.getAttribute("totalCount")+1);
            wirter.write("<h1>系统访问人数:"+context.getAttribute("totalCount")+"</h1>");
            user= users.get(users.indexOf(user));
            user.setLoginCount(user.getLoginCount()+1);
            wirter.write("<h1>登录系统次数："+user.getLoginCount()+"</h1>");
            if (user.getLastLoginDate()!=null){
                wirter.write("<h1>上次登录系统的时间："+user.getLastLoginDate()+"</h1>");
            }
            user.setLastLoginDate(new Date());

        }else {
            wirter.write("<h1>账号密码错误</h1>");
        }
    }
}
