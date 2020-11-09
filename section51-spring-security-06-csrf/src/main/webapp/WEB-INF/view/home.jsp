<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <!-- Add a logout button-->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>