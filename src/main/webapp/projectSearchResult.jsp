<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Result</title>
    <jsp:include page="nav.jsp"></jsp:include>
    <jsp:include page="headPlusLoginStatus.jsp"/>
</head>
<body>

<c:choose>
    <c:when test="${not empty foundProjectSession}">
        <ul>
            <li>Name: ${foundProjectSession.projectName}</li>
            <li>Team: ${foundProjectSession.team}</li>
            <li>Start date: ${foundProjectSession.start}</li>
            <li>End date: ${foundProjectSession.end}</li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>We couldn't find that project </p>
        <p><a href="Controller?command=ProjectSearch">Go back to the search form.</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
