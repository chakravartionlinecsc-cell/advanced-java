package com.cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Handle GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = null;
        int count = 0;

        // Read cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    userName = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // Increase visit count
        if (userName != null) {
            count++;
        }

        // Create/update cookies
        if (userName != null) {
            Cookie userCookie = new Cookie("user", userName);
            Cookie countCookie = new Cookie("count", String.valueOf(count));

            userCookie.setMaxAge(30);   // expires in 30 seconds
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // HTML Output
        out.println("<html>");
        out.println("<head><title>Cookie Demo</title></head>");
        out.println("<body>");

        if (userName != null) {
            out.println("<h2 style='color:blue'>Welcome back, " + userName + "!</h2>");
            out.println("<h3 style='color:green'>You have visited this page " + count + " times!</h3>");
            out.println("<p><b>Note:</b> Cookie expires in 30 seconds.</p>");

            // Logout button
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");

        } else {
            out.println("<h2 style='color:red'>Welcome! Please enter your name:</h2>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("Name: <input type='text' name='userName' required>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST request
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        // If user entered name → create cookies
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            Cookie countCookie = new Cookie("count", "1");

            userCookie.setMaxAge(30);
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);

        } else {
            // Logout: delete cookies
            Cookie userCookie = new Cookie("user", "");
            Cookie countCookie = new Cookie("count", "");

            userCookie.setMaxAge(0);
            countCookie.setMaxAge(0);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // Redirect back
        response.sendRedirect("CookieServlet");
    }
}
