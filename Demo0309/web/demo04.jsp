<%@ page import="com.demo.bean.Studennt" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 11587
  Date: 2021-03-09
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP直接获取</h1>
<table border="1px">
    <tr><th colspan="4">学生信息表</th></tr>

<% Studennt studennt = new Studennt(1001, "张三", 21, "照片1");
    Studennt studennt1 = new Studennt(1002, "张三1", 22, "照片2");
    Studennt studennt2 = new Studennt(1003, "张三2", 23, "照片3");
    Studennt studennt3 = new Studennt(1004, "张三3", 24, "照片4");
    Studennt studennt4 = new Studennt(1005, "张三4", 25, "照片5");
    Studennt studennt5 = new Studennt(1006, "张三5", 26, "照片6");
    Studennt studennt6 = new Studennt(1007, "张三6", 26, "照片7");
    Studennt studennt7 = new Studennt(1008, "张三7", 27, "照片8");
    Studennt studennt8 = new Studennt(1009, "张三8", 28, "照片9");
    Studennt studennt9 = new Studennt(1010, "张三9", 28, "照片10");
    ArrayList<Studennt> lists = new ArrayList<>();
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
    for (int i = 0; i < lists.size(); i++) {
%>
   <tr><td><%= lists.get(i).getId()%></td>
       <td><%= lists.get(i).getName()%></td>
       <td><%= lists.get(i).getAge()%></td>
       <td><%= lists.get(i).getPhone()%></td>
   </tr>
<%
    }
%>
</table>
<h1>servlet方法</h1>
    <% ArrayList<Studennt> lists1 = (ArrayList<Studennt>) request.getAttribute("lists"); %>
<table border="1px">
    <%
    for (int i = 0; i < lists1.size(); i++) {
    %>
    <tr><td><%= lists1.get(i).getId()%></td>
        <td><%= lists1.get(i).getName()%></td>
        <td><%= lists1.get(i).getAge()%></td>
        <td><%= lists1.get(i).getPhone()%></td>
    </tr>
    <%
        }
    %>
       </table>

</body>
</html>
