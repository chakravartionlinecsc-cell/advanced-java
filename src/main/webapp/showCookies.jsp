<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie c : cookies){
        out.print("Name: " + c.getName() + "<br>");
        out.print("Value: " + c.getValue() + "<br>");
        out.print("Max Age: " + c.getMaxAge() + "<br><br>");
    }
} else {
    out.print("No cookies found.");
}
%>

</body>
</html>