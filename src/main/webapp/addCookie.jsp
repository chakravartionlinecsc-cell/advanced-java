<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Cookie</title>
</head>
<body>

<h2>Cookie Information</h2>

<%
String name = request.getParameter("cname");
String domain = request.getParameter("cdomain");
int age = Integer.parseInt(request.getParameter("cage"));

// create cookie
Cookie cookie = new Cookie(name, domain);

// set max age
cookie.setMaxAge(age);

// optional: set domain (can be ignored in localhost testing)
cookie.setDomain(domain);

// add cookie to response
response.addCookie(cookie);

// display cookie info
out.print("Cookie Name: " + name + "<br>");
out.print("Domain: " + domain + "<br>");
out.print("Max Age: " + age + " seconds<br>");
%>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>