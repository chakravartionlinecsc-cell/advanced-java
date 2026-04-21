<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="addCookie.jsp" method="post">
    Cookie Name: <input type="text" name="cname"><br/><br/>
    
    Domain: <input type="text" name="cdomain"><br/><br/>
    
    Max Expiry Age (seconds): <input type="text" name="cage"><br/><br/>
    
    <input type="submit" value="Add Cookie">
</form>

</body>
</html>