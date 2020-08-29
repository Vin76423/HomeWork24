package by.tms.listeners;

import by.tms.entity.User;
import by.tms.entity.UsersOperation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<User> users = new ArrayList<>();
        sce.getServletContext().setAttribute("users", users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("report", new ArrayList<UsersOperation>());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
