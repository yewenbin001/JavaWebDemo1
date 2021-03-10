package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author ：小兵
 * @date ：2021-03-08 14:25
 * @Description:
 */
@WebServlet(name = "FileDownloadServlet01", urlPatterns = "/fileDownload.do")
public class FileDownloadServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //实现文件下载，获取到响应对象的字节输出流 在线考试管理系统
        OutputStream outputStream = resp.getOutputStream();
        //用来表示服务器端需要传输游览器端的文件
        File file = new File("D:\\Users\\11587\\Pictures\\国家的栋梁 (2).jpg");
        //通过响应设置，设置响应头，设置编码方式 ，告诉游览器要下载文件
        resp.setHeader("content-disposition", "attachement;fileName=" + java.net.URLEncoder.encode("国家的栋梁.jpg", "UTF-8"));
        //response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        //创建一个输入流
        InputStream inputStream=new FileInputStream(file);
        //设置一个字节数组，用于每次读取长度
        byte[] bytes=new byte[1024];
        //设置一个长度用于判断是否读取完
        int length =0;
        //判断是否有读取到数据
        while ((length=inputStream.read(bytes))!=-1){
            //输出流
            outputStream.write(bytes);
            //刷新流
            outputStream.flush();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
