<%@ page import="java.util.List" %>
<%@ page import="com.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: like
  Date: 2019/9/8
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<%  List<Student> list=(List<Student>)request.getAttribute("students");%>

<table >
    <tr>
        <th>name</th>
        <th>id</th>
        <th>grade</th>
        <th>操作</th>
    </tr>
        <%
            for(Student s:list){
%>
    <tr>
        <th><%=s.getName()%></th>
        <th><%=s.getId()%></th>
        <th><%=s.getGrade()%></th>
        <th><a href="/mvc1_0_war_exploded/delservlet?id=<%=s.getId()%>"> 删除</a></th>
    </tr>
        <%    }
        %>

</table>


</body>
</html>
