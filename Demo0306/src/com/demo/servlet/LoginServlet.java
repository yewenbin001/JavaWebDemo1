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
 * @date ：2021-03-07 11:40
 * @Description:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
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
        //getParameter 通过写在input当中的name 获取到对应的value值
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password);
        //响应中文乱码处理,乱码的根本原因：字符在读和写的过程中 使用的编码不一样
        resp.setContentType("text/html;charset=utf-8");
        //获取响应当中的字符输出流并且向客户端输出字符串
        Writer writer=resp.getWriter();
        //判断用户集合中是否有这个用户
        if (users.contains(user)){
            //往页面传输用户名
            writer.write("<h1>"+username+"登陆成功</h1>");
            //设置系统登录人数加一
            context.setAttribute("totalCount",(int)context.getAttribute("totalCount")+1);
            //往页面传输系统登录人数
            writer.write("<h1>第"+context.getAttribute("totalCount")+"位登录的用户</h1>");
            //获取用户在用户集合中的下标
            int a =users.indexOf(user);
            //使user和集合中的指向同一地址
            user=users.get(a);
            //用户登录次数加1
            user.setLoginCount(user.getLoginCount()+1);
            //往页面传输用户登录次数
            writer.write("<h1>您是第"+user.getLoginCount()+"次登录系统</h1>");
            //判断用户是否第一次登录，是否有上次登录时间，有就往页面传输上次都登录时间
            if (user.getLastLoginDate()!=null){
                writer.write("<h1>上次登录系统时间"+user.getLastLoginDate()+"</h1>");
            }
            //更新用户登录时间
            user.setLastLoginDate(new Date());
        }else{
            writer.write("<h1>用户密码错误</h1>");
        }

    }
}
