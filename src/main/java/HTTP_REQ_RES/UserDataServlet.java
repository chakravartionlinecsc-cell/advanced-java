package HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;   // ✅ Important import
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processUser")
public class UserDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String message;

        // Validation
        if (username == null || username.trim().isEmpty()) {
            message = "Username is required";
        } else {
            message = "User data processed successfully";

            // Store data in request
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("designation", designation);
        }

        // Set message
        request.setAttribute("message", message);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Redirect GET request to form
        response.sendRedirect("index.jsp");
    }
}