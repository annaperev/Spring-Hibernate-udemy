<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="securoty" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <title>Anna Company home page</title>
</head>
<body>
    <h2>Anna Company Home Page</h2>
    <hr>
    <p>
    Welcome to Anna company home page
    </p>

    <hr>
    <!-- Display user name and role -->
    <p>
        User: <securoty:authentication property="principal.username"/>
        <br><br>
        Role(s): <securoty:authentication property="principal.authorities"/>
    </p>

    <hr>

    <!-- Add a logout button-->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>