package ru.temkiiiiin.model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/index" })
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        if (userName == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}