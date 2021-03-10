package com.demo.servlet;

import com.demo.bean.Studennt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ：小兵
 * @date ：2021-03-09 11:42
 * @Description:
 */
@WebServlet(name = "StudentServlet",urlPatterns = "/demo04.do")
public class StudentServlet extends HttpServlet {
    ArrayList<Studennt> lists =null;
    public void StudentServlet() {
        lists = new ArrayList<>();
        Studennt studennt = new Studennt(1001, "se张三", 21, "照片1");
        Studennt studennt1 = new Studennt(1002, "se张三1", 22, "照片2");
        Studennt studennt2 = new Studennt(1003, "se张三2", 23, "照片3");
        Studennt studennt3 = new Studennt(1004, "se张三3", 24, "照片4");
        Studennt studennt4 = new Studennt(1005, "se张三4", 25, "照片5");
        Studennt studennt5 = new Studennt(1006, "se张三5", 26, "照片6");
        Studennt studennt6 = new Studennt(1007, "se张三6", 26, "照片7");
        Studennt studennt7 = new Studennt(1008, "se张三7", 27, "照片8");
        Studennt studennt8 = new Studennt(1009, "se张三8", 28, "照片9");
        Studennt studennt9 = new Studennt(1010, "se张三9", 28, "照片10");
        lists.add(studennt);
        lists.add(studennt1);
        lists.add(studennt2);
        lists.add(studennt3);
        lists.add(studennt4);
        lists.add(studennt5);
        lists.add(studennt6);
        lists.add(studennt7);
        lists.add(studennt8);
        lists.add(studennt9);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentServlet();
        req.setAttribute("lists",lists);
        req.getRequestDispatcher("/demo04.jsp").forward(req, resp);
    }
}
