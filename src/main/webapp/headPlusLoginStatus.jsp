<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="style/Normalize.css">
    <link rel="stylesheet" href="style/stylesheet.css">
</head>
<body>
<header>
    <h2>
        <c:choose>
            <c:when test="${loginUserSession!=null}">
                <p>You are logged in as ${loginUserSession.firstName} ${loginUserSession.lastName}.</p>
            </c:when>
            <c:otherwise>
                <p>You are not logged in.</p>
            </c:otherwise>
        </c:choose>
    </h2>
</header>
