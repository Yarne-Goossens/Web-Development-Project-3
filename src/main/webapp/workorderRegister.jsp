<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Work Register</title>
    <jsp:include page="nav.jsp"></jsp:include>
    <jsp:include page="headPlusLoginStatus.jsp"/>
</head>
<body>

<h2>
    Register Workorder
</h2>
<c:choose>
    <c:when test="${loginUserSession!=null}">
        <p>You are logged in as ${loginUserSession.firstName} ${loginUserSession.lastName}.</p>

<main>
    <div>
        <c:if test="${not empty errors}">
        <div id="error" class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
            </c:if>
        </div>

        <form name="formulier" method="POST" action="Controller?command=WorkorderRegisterProcessing&user=${loginUserSession.firstName}" novalidate>

            <p><label for="team">Team</label>
                <input readonly type="text" id="team" name="team" required value="${loginUserSession.team}"></p>

            <p><label for="date">Date</label>
                <input type="date" id="date" name="date" required value="${datePreviousValue}"></p>

            <p><label for="startTime">Starttime</label>
                <input type="time" class="without_ampm" id="startTime" name="startTime" step="1"  required value="${startPreviousValue}"></p>

            <p><label for="endTime">Endtime</label>
                <input type="time" class="without_ampm" id="endTime" name="endTime" step="1"  required value="${endPreviousValue}"></p>

            <label for="description">Description</label>
            <textarea id="description" name="description" required value="${employeePreviousValue}"></textarea>

            <p><input id="submit" type="submit" value="Registreer"></p>

        </form>
            </c:when>
            <c:otherwise>
            <p>You can't add a workorder if you are not logged in. <a href="index.jsp">login here</a></p>
            </c:otherwise>
            </c:choose>
</main>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
