package ru.temkiiiiin.model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/login" })
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String errorString = null;
        boolean hasError = false;

        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()
            || !(userName.equals("ts") && password.equals("123"))) {
            hasError = true;
            errorString = "Required username and password!";
        }

        if (hasError) {
            request.setAttribute("errorString", errorString);
            response.getWriter().print(errorString + " " + userName + " " + password);

            //RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/login.jsp");
            //dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loginedUser", userName);

            response.getWriter().print(errorString + " " + userName + " " + password);
            //response.sendRedirect(request.getContextPath() + "/views/index.jsp");
        }
    }

    public static void storeUserCookie(HttpServletResponse response, String userName) {
        Cookie cookieUserName = new Cookie("USER_NAME", userName);
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }

}
