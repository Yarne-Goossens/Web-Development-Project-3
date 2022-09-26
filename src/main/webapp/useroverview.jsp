<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<div id="container">
<header>
<h1><span>XXX</span></h1>
    <jsp:include page="nav.jsp"/>
<h2>
User Overview
</h2>

</header><main>
    <main>
        <table>
            <c:choose>
                <c:when test="${not empty useroverview}">
                    <h2>Look at your planets</h2>
                    <tr>
                        <th>id</th>
                        <th>email</th>
                        <th>firstname</th>
                        <th>name</th>
                        <th>team</th>

                    </tr>

                    <c:forEach var="user" items="${useroverview}">
                        <tr>
                            <td>${user.userid}
                            </td>
                            <td>${user.email}
                            </td>
                            <td>${user.firstName}
                            </td>
                            <td>${user.lastName}
                            </td>
                            <td>${user.team}
                            </td>
                        </tr>
                    </c:forEach>

                </c:when>
                <c:otherwise>
                    <p>There are no planets to show </p>
                </c:otherwise>
            </c:choose>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>