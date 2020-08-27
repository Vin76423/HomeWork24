package by.tms.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "filter", urlPatterns = {"/calc", "/report"}, initParams = @WebInitParam(name = "param", value = "This is some parameters!!!"))
public class Filter extends HttpFilter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println(config.getInitParameter("param"));
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            res.sendRedirect("/");
        }else{
            chain.doFilter(req, res);
        }
    }
}
