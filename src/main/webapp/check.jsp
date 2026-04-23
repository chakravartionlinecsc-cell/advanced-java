<%
    String user = (String) session.getAttribute("user");

    if (user == null) {
%>
        <h2>Session Expired!</h2>
        <p>Please go back and enter your name again.</p>
        <a href="index.jsp">Go Back</a>
<%
    } else {
%>
        <h2>Hello <%= user %>!</h2>
        <p>Your session is still active.</p>
<%
    }
%>