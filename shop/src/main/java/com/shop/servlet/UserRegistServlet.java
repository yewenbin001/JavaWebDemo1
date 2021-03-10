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
 * @date ：2021-03-09 19:39
 * @Description:
 */
@WebServlet(name = "UserRegistServlet",urlPatterns = "/regist")
public class UserRegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str=VerifyCodeServlet.str;
        String code=req.getParameter("code");
        System.out.println("str:"+str);
        System.out.println("code:"+code);
        if (str.equals(code)){
            User user =new User(req.getParameter("username"),req.getParameter("password"),req.getParameter("email"));
            UserService userService=new UserService();
            boolean result = userService.addUser(user);
            if (result){
                req.setAttribute("success","注册成功");
                req.getRequestDispatcher("/regist_success.html").forward(req,resp);
            }else{
                req.setAttribute("success","注册失败");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }
        }else{
            req.setAttribute("success","验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }

    }
}
