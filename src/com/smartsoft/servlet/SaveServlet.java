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

@WebServlet(name = "SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String country = request.getParameter("country");

        Employee employee = new Employee();
        employee.setName(username);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setCountry(country);

        int status = EmployeeDao.save(employee);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (status > 0){
//            request.getRequestDispatcher("addSuccess.html").include(request,response);
            response.sendRedirect("index.html");
        }else {
            printWriter.print("Sorry something went wrong! Unable to save record!");
        }
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
