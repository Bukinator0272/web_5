package servlet;

import controller.EmpController;
import model.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/get-emp")
public class EmpServlet extends HttpServlet {

    private EmpController empController = new EmpController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps = new ArrayList<>();
        if (req.getParameter("inputName") == null) {
            emps.add(empController.read(Integer.valueOf(req.getParameter("id"))));
            req.setAttribute("emps", emps);
            getServletContext().getRequestDispatcher("/view.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("emps", empController.getAllByName(req.getParameter("inputName")));
        getServletContext().getRequestDispatcher("/view.jsp").forward(req, resp);
    }

}
