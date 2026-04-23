<%
    String name = request.getParameter("uname");
    String timeStr = request.getParameter("time");

    int time = Integer.parseInt(timeStr); // minutes

    // store name in session
    session.setAttribute("user", name);

    // set session expiry (convert minutes to seconds)
    session.setMaxInactiveInterval(time * 60);
%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Hello <%= name %>!</h2>

    <p>Session will expire in <%= time %> minute(s).</p>

    <a href="check.jsp">Click here to check session status</a>
</body>
</html>