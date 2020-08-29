package by.tms.servlet;

import by.tms.entity.UsersOperation;
import by.tms.service.Calc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/calc", loadOnStartup = 1)
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");


        String result;
        try {
            result = String.valueOf(Calc.valueOf(type).run(Double.parseDouble(num1), Double.parseDouble(num2)));
        }catch (IllegalArgumentException e){
            result = "invalid parameters!!!";
        }catch (ArithmeticException e){
            result = "you can't division by zero";
        }

        List<UsersOperation> report = (List<UsersOperation>) req.getSession().getAttribute("report");
        report.add(new UsersOperation(num1, num2, type, result));

        req.setAttribute("result", result);
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
