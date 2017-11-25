<%@ page import="com.smartsoft.bean.AdminBean" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 22/11/2017
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Employee</title>
</head>
<body>
<%
    AdminBean adminBean = (AdminBean) request.getAttribute("Admin");
    out.print("Welcome back " + adminBean.getUsername());
%>
<%@include file="portail.html"%>
</body>
</html>
