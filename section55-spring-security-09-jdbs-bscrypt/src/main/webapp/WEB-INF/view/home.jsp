<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>
    <hr>
    <!-- Add a link to point to/leaders ... this is for the managers-->
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>
    <!-- Add a link to point to/systems ... this is for the admin-->
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
            (Only for Admin peeps)
        </p>
    </security:authorize>

    <!-- Add a logout button-->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>