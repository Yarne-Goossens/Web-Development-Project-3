<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Users</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<header>
    <h2>
        <jsp:include page="loginStatus.jsp"/>
    </h2>
    <jsp:include page="nav.jsp"/>
<h2>
User Overview
</h2>

</header><main>
    <main>
        <table>
            <c:choose>
                <c:when test="${not empty useroverview}">
                    <h2>Users</h2>
                    <tr>
                        <th>User Id</th>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>

                    <c:forEach var="user" items="${useroverview}">
                        <tr>
                            <td>${user.userid}</td>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.team}</td>
                            <td>CEO</td>
                            <td>edit</td>
                            <td>x</td>
                        </tr>
                    </c:forEach>

                </c:when>
                <c:otherwise>
                    <p>There are no user to show.</p>
                </c:otherwise>
            </c:choose>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</body>
</html>