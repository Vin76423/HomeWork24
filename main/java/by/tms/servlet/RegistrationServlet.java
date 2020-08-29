package by.tms.servlet;

import by.tms.entity.User;
import com.sun.net.httpserver.HttpContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = (List<User>) getServletContext().getAttribute("users");
        User user = new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("password"));
        users.add(user);

        resp.sendRedirect("/");
    }
}
