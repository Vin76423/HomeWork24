package by.tms.servlet;

import by.tms.entity.UsersOperation;
import by.tms.service_2.Calc;
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
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");


//.................service_1.......................................................
//        String result;
//        try {
//            result = String.valueOf(TypeUtil.OPERATION.get(type).run(Double.parseDouble(num1), Double.parseDouble(num2)));
//        }catch (IllegalArgumentException | NullPointerException e){
//            result = "invalid parameters!!!";
//        }

//.................service_2.......................................................
        String result;
        try {
            result = String.valueOf(Calc.valueOf(type).run(Double.parseDouble(num1), Double.parseDouble(num2)));
        }catch (IllegalArgumentException e){
            result = "invalid parameters!!!";
        }

        List<UsersOperation> report = (List<UsersOperation>) req.getSession().getAttribute("report");
        report.add(new UsersOperation(num1, num2, type));

        resp.getWriter().println(result);
    }
}
