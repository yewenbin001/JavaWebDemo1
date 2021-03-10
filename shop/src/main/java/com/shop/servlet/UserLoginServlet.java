package com.shop.servlet;

import com.shop.bean.User;
import com.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：小兵
 * @date ：2021-03-09 20:33
 * @Description:
 */
@WebServlet(name = "UserLoginServlet",urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        UserService userService=new UserService();
        user=userService.userLogin(user);
        if (user!=null){
            req.setAttribute("success","登录成功");
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }else{
            req.setAttribute("success","账号密码有误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
