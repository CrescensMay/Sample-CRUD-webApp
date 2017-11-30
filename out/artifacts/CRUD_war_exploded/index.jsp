<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 24/11/2017
  Time: 2:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@ page import="com.smartsoft.dao.EmployeeDao" %>
<%@ page import="com.smartsoft.bean.Employee" %>
<%@ page import="java.util.List" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    out.print("<html><head>");
    out.print("<link href=\"https://fonts.googleapis.com/css?family=Anton\" rel=\"stylesheet\">\n" +
            "    <link rel=\"stylesheet\" href=\"main.css\">");
    out.print("</head>");
    out.print("<style>");
    out.print("table {color: #333; /* Lighten up font color */\n" +
            "    font-family: 'Aton';\n" +
            "    width: 100%; \n" +
            "}\n" +
            "\n" +
            "td, th { border: 1px solid #CCC; height: 30px; }\n" +
            "\n" +
            "th {  \n" +
            "    background: #F3F3F3;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            "\n" +
            "td {  \n" +
            "    background: #FAFAFA;\n" +
            "    text-align: center;\n" +
            "}");
    out.print("table button {font-size:16px;border:none;\n" +
            "    color: #fff;\n" +
            "    font-family: 'Aton';\n" +
            "    height: 27px;\n" +
            "    border-radius: 5px;\n" +
            "    text-align:center;" +
            "    position:relative;" +
            "    margin-left:7px;" +
            "}\n");
    out.print("table a {color:#ffffff;}");
    out.print("table{\n" +
            "    color: #333; /* Lighten up font color */\n" +
            "    font-family: 'Aton';\n" +
            "    width: 100%; \n" +
            "}\n" +
            "\n" +
            "td, th { border: 1px solid #CCC; height: 30px; }\n" +
            "\n" +
            "th {  \n" +
            "    background: #F3F3F3;\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            "p { \n" +
            " font-family:'Aton';\n"+
            "color: #ffffff;\n" +
            "}" +
            "\n" +
            "td {  \n" +
            "    background: #FAFAFA;\n" +
            "    text-align: center;\n" +
            "}");
    out.print("</style>");
    out.print("<body>\n");
    out.print("<div class='index'>");
//    out.println("<h1>Only for Quering Employee Record</h1>");
    String input = request.getParameter("val");
    if (input == null || input.trim().equals("")){
      out.print("<p>Please enter name!</p>");
    }else {
      //        int roll = Integer.valueOf(input);
      Connection connection = EmployeeDao.getConnection();
//      String sql = "SELECT * FROM emp where username LIKE '\"+input+\"%'";
      try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM emp WHERE emp.username LIKE '"+input.toUpperCase()+"%' OR emp.username LIKE '%" + input + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
          out.print("<p>No record found!</p>");
        }else {
          out.print("<table>");
          out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th></tr>");
          List<Employee> list= EmployeeDao.getAllEmployees();
//          for (Employee employee: list)
          while (resultSet.next()){
            out.print("<tr><td>" + resultSet.getInt(1)+"</td>"
                    + "<td>" + resultSet.getString(2)+"</td>"
                    + "<td>" + resultSet.getString(3)+"</td>"
                    + "<td>" + resultSet.getString(5)+"</td>"+
//                    + "<td><button type='button' style='width:80px;background-color:rgba(195, 184, 33, 0.85)'><a href='EditServlet?id="+ employee.getId()+"'>Edit</a></button>" +
//                        "<button type='button' style='width:90px;background-color:rgb(168, 21, 16);'><a href='DeleteServlet?id="+ employee.getId()+"'>Delete</a></button></td>" +
                    "</tr>");
          }
          out.print("</table>");
        }
        out.print("</div>");
        out.print("</body></html>");
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
        out.close();
      }
    }
  %>
  </body>
</html>
