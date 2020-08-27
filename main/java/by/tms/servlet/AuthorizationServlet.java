package by.tms.servlet;

import by.tms.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = (List<User>) getServletContext().getAttribute("users");
        for (User user : users) {
            if (user.getLogin().equals(req.getParameter("login")) && user.getPassword().equals(req.getParameter("password"))){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("report", new ArrayList<>());
            } else {
                resp.sendRedirect("/");
            }
        }
    }
}
