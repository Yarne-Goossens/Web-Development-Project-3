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
    <c:when test="${not empty foundProject}">
        <ul id="resList">
            <li>Name: ${foundProject.projectName}</li>
            <li>Team: ${foundProject.team}</li>
            <li>Start date: ${foundProject.start}</li>
            <li>End date: ${foundProject.end}</li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>We couldn't find that project </p>
        <p><a href="Controller?command=ProjectSearch">Go back to the search form.</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
