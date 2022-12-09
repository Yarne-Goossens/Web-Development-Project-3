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
    <c:when test="${not empty foundWorkorder}">
        <ul>
            <li>Name: ${foundWorkorder.workorderId}</li>
            <li>Userid: ${foundWorkorder.userId}</li>
            <li>Team: ${foundWorkorder.team}</li>
            <li>Date: ${foundWorkorder.date}</li>
            <li>Description: ${foundWorkorder.description}</li>
            <li>End time: ${foundWorkorder.endTime}</li>
            <li>Start time: ${foundWorkorder.startTime}</li>
            <li>Employee: ${foundWorkorder.employee}</li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>We couldn't find that project </p>
        <p><a href="Controller?command=WorkorderSearch">Go back to the search form.</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>
