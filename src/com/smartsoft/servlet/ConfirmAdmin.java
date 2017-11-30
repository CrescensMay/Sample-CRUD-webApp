package com.smartsoft.servlet;

import com.smartsoft.bean.AdminBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConfirmAdmin")
public class ConfirmAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminBean adminBean = new AdminBean();
        adminBean.setUsername(username);
        adminBean.setPassword(password);
        request.setAttribute("Admin", adminBean);
        session.setAttribute("Admin",adminBean);
        if(adminBean.isValid()){
            request.getRequestDispatcher("portail.html").include(request,response);
        }else {
            request.getRequestDispatcher("errorLogin.jsp").include(request,response);
        }
    }

}
