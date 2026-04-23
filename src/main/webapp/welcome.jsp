<%@ page import="java.util.Date" %>
<%
    // Set session expiry to 1 minute
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    // Store name in session
    if (name != null) {
        session.setAttribute("username", name);
    } else {
        name = (String) session.getAttribute("username");
    }

    // Session details
    String sessionId = session.getId();
    Date createTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());
%>

<html>
<head>
    <title>Session Tracking</title>
</head>
<body>

<h2>Hello <%= name %>!</h2>

<h3>Session Information</h3>
<p><b>Session ID:</b> <%= sessionId %></p>
<p><b>Creation Time:</b> <%= createTime %></p>
<p><b>Last Access Time:</b> <%= lastAccessTime %></p>

<br>
<b>Note:</b> Session expires after 1 minute of inactivity.

</body>
</html>