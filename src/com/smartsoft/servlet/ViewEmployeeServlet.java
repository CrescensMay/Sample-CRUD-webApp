package com.smartsoft.servlet;

import com.smartsoft.bean.Employee;
import com.smartsoft.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import static java.awt.Color.white;
import static java.awt.SystemColor.window;

@WebServlet(name = "ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html><head>");
        printWriter.print("<link href=\"https://fonts.googleapis.com/css?family=Anton\" rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"main.css\">");
        printWriter.print("<title>All Employees</title>");
        printWriter.print("<head>");
        printWriter.print("<style>");
        printWriter.print("table button {font-size:16px;border:none;\n" +
                "    color: #fff;\n" +
                "    font-family: 'Aton';\n" +
                "    height: 27px;\n" +
                "    border-radius: 5px;\n" +
                "    text-align:center;" +
                "    position:relative;" +
                "    margin-left:7px;" +
                "}\n");
        printWriter.print("table a {color:#ffffff;}");
        printWriter.print("table{\n" +
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
                "\n" +
                "td {  \n" +
                "    background: #FAFAFA;\n" +
                "    text-align: center;\n" +
                "}");
        printWriter.print("</style>");
        printWriter.print("<body>\n" +
                "<header>\n" +
                "    <img src=\"./images/crud.png\" alt=\"Ceci est une image\">\n" +
                "    <ul>\n" +
                "        <li><a href=\"LogoutServlet\">Logout</a></li>\n" +
                "    </ul>\n" +
                "</header>");
        printWriter.print("<div class='index'style='height:100%;width:100%;min-height:1000px;'>");
        printWriter.println("<h1>Employees List</h1>");
        List<Employee> list= EmployeeDao.getAllEmployees();
        printWriter.print("<table width='100%' style='color:#000;font-size:20px;font-family:'Aton';'>");
        printWriter.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Date</th><th>Actions</th></tr>");//<th>Edit</th>
        for(Employee employee:list){
            printWriter.print("<tr><td>"+employee.getId()+ "</td><td>"+employee.getName()+"</td><td>"+employee.getEmail()+"</td><td>"+employee.getCountry()+
                    "</td><td>"+employee.getDate()+"</td>"+"<td><button type='button' style='width:80px;background-color:rgba(195, 184, 33, 0.85)'><a href='EditServlet?id="+employee.getId()+"'>Edit</a></button>" +
                    "<button type='button' style='width:90px;background-color:rgb(168, 21, 16);'><a href='DeleteServlet?id="+employee.getId()+"'>Delete</a></button></td></tr>");
        }
        printWriter.print("</table>");
        printWriter.println("<button type='button' id='viewemp' style='margin-top:10px;'><a href='index.html'>Add New Employee</a></button>");
        printWriter.print("</div>");
        printWriter.print("<footer><p>Copyright &copy;\n" +
                "    <script language=\"javascript\" type=\"text/javascript\"> document.write(new Date().getFullYear())</script>\n" +
                "    SmartSoft / Terms of Services / Privacy Policy, by <strong> Crescens.K</strong> / <a class=\"link\" href=\"\" style=\"color: #ffffff;\" onmouseover=\"this.style.textDecoration='underline'\" onmouseleave=\"this.style.textDecoration='none'\">About</a> /\n" +
                "    <a class=\"link\" href=\"\" style=\" color: #ffffff;\" onmouseover=\"this.style.textDecoration='underline'\" onmouseleave=\"this.style.textDecoration='none'\"\">Contact</a></p>\n" +
                "</footer>");
        printWriter.print("</body></html>");
        printWriter.close();
    }
}
