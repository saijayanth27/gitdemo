package wipro.com;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Task1")
public class Task1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");
        String operation = request.getParameter("operation"); 

        if (t1 == null || t1.isEmpty() || t2 == null || t2.isEmpty()) {
            response.getWriter().println("Error: Please enter both numbers.");
            return;
        }
            int i = Integer.parseInt(t1);
            int j = Integer.parseInt(t2);
            int result = 0;
            String operationName = "";
            switch (operation) {
                case "Add":
                    result = i + j;
                    operationName = "Addition";
                    break;
                case "Sub":
                    result = i - j;
                    operationName = "Subtraction";
                    break;
                case "Mul":
                    result = i * j;
                    operationName = "Multiplication";
                    break;
                case "Div":
                    if (j == 0) {
                        response.getWriter().println("Error: Division by zero is not allowed.");
                        return;
                    }
                    result = i / j;
                    operationName = "Division";
                    break;
                default:
                    response.getWriter().println("Error: Invalid operation.");
                    return;
            }
            response.getWriter().println(operationName + " Result: " + result);
        } 
    }
