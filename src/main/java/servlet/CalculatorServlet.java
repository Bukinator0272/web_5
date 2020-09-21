package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int firstNum = Integer.parseInt(req.getParameter("firstNum"));
        int secondNum = Integer.parseInt(req.getParameter("secondNum"));
        String sign = req.getParameter("sign");
        String temp = firstNum + " " + sign + " " + secondNum + " = ";
        if (secondNum == 0 && sign.equals("/")) {
            req.setAttribute("error", "Division by zero!");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }
        switch (sign) {
            case "+":
                req.setAttribute("answer", temp + (firstNum + secondNum));
                break;
            case "-":
                req.setAttribute("answer", temp + (firstNum - secondNum));
                break;
            case "*":
                req.setAttribute("answer", temp + (firstNum * secondNum));
                break;
            case "/":
                req.setAttribute("answer", temp + (firstNum / secondNum));
                break;
        }
        req.setAttribute("firstNum", firstNum);
        req.setAttribute("secondNum", secondNum);
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }

}
