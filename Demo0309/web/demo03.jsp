<%--
  Created by IntelliJ IDEA.
  User: 11587
  Date: 2021-03-09
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成绩89分</h1>
<%
    int grades = 89;
    if (grades >= 90) {
%>
<h1>成绩评级：A</h1>
<% } else if (grades >= 80) {
%>
<h1>成绩评级：B</h1>
<% } else if (grades >= 60) {
%>
<h1>成绩评级：C</h1>
<% } else if (grades < 60) { %>
<h1>成绩评级：D</h1>
<%} %>

<%
    for (int i = 1; i < 10; i++) {
%>
<h1>
<%
    for (int j = i; j < 10; j++) {
%>
<%=i%>*<%=j%>=<%= i * j%>&nbsp;&nbsp;&nbsp;
<%
    }
%>
</h1>
<%
    }
%>

</body>
</html>
