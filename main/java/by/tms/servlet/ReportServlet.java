package by.tms.servlet;

import by.tms.entity.UsersOperation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UsersOperation> report = (List<UsersOperation>) req.getSession().getAttribute("report");
        if (report.isEmpty()) {
            resp.getWriter().println("report is empty");
            return;
        }
        resp.getWriter().println(report.stream().flatMap( o -> Stream.of(o.toString() + "\n")).collect(Collectors.toList()));
    }
}
