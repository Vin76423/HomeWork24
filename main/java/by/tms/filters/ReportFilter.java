package by.tms.filters;

import by.tms.entity.UsersOperation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "reportFilter", urlPatterns = "/report")
public class ReportFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("report") == null || ((List<?>) req.getSession().getAttribute("report")).isEmpty()) {
            res.sendRedirect("/");
        }else{
            chain.doFilter(req, res);
        }
    }
}
