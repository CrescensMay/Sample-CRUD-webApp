<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 22/11/2017
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" href="main.css">--%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}main.css" />
    <title>Admin Login</title>
</head>
<body>
<%@include file="adminLogin.html"%>
<script>alert("Sorry Wrong username or password!");</script>
</body>
</html>
