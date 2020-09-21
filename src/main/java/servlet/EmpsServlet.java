package servlet;

import controller.EmpController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-emps")
public class EmpsServlet extends HttpServlet {

    private EmpController empController = new EmpController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.removeAttribute("emps");
        req.setAttribute("emps", empController.getAll());
        getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

}
