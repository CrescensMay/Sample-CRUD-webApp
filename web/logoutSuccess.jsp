<%@ page import="com.smartsoft.bean.AdminBean" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 23/11/2017
  Time: 5:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    AdminBean adminBean = (AdminBean) request.getAttribute("Admin");
    out.print("Thanks for using the Apllication, You have succesfully logged out back " + adminBean.getUsername());
%>
<%@include file="adminLogin.html"%>
</body>
</html>
