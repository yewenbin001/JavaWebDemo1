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
import java.util.List;

/**
 * @author ：小兵
 * @date ：2021-03-05 11:31
 * @Description:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    List<User> users = null;
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
        context = config.getServletContext();
        context.setAttribute("totalCount", 0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getParameter 通过写在input当中的name 获取到对应的value值
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        //响应中文乱码处理,乱码的根本原因：字符在读和写的过程中 使用的编码不一样
        resp.setContentType("text/html;charset=utf-8");
        //如何获取响应当中的字符输出流并且向客户端输出字符串
        Writer writer=resp.getWriter();
        //字符流基于转换流
        if (users.contains(user)){
            writer.write("<h1>"+username+"登陆成功</h1>");
            //需求：当用户登录成功后，在浏览器页面上提示用户，您是第几个登陆成功的用户（使用ServletContext）
            context.setAttribute("totalCount",(int)context.getAttribute("totalCount")+1);
            writer.write("<h1>第"+context.getAttribute("totalCount")+"个登录的用户</h1>");
            //扩展：弄一个集合，模拟数据库，登录在集合中校验。用户登录成功后，
            //获取到用户上次的登录时间(如果之前没有登录，就不显示时间)，该用户第几次登录。
            for (int i =0;i< users.size();i++){
                if (users.get(i).equals(user)){
                   user=users.get(i);
                   user.setLoginCount(user.getLoginCount()+1);
                   writer.write("<h1>这次是您第"+user.getLoginCount()+"次登录</h1>");
                   if (user.getLoginCount()!= null){
                       writer.write("<h1>您上次登录时间；"+user.getLastLoginDate()+"</h1>");
                   }
                   user.setLastLoginDate(new Date());
                }
            }
        }else {
            writer.write("<h1>用户名或密码错误</h1>");
        }

    }
}
