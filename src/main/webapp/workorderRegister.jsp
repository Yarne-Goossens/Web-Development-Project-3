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

        <form name="formulier" method="POST" action="Controller?command=WorkorderRegisterProcessing" novalidate>

            <p><label for="employee">Employee</label>
                <input type="text" id="employee" name="employee" required value="${employeePreviousValue}"></p>

            <<label for="description">Description</label>
            <textarea id="description" name="description" required value="${employeePreviousValue}"></textarea>

            <c:choose>
                <c:when test="${not empty teamPreviousValue}">

                    <label for="team">Team</label>
                    <select name="team" id="team">
                        <option value="${teamPreviousValue}">${teamPreviousValue}</option>
                        <option value="alpha">alpha</option>
                        <option value="beta">beta</option>
                        <option value="gamma">gamma</option>
                        <option value="delta">delta</option>
                        <option value="epsilon">epsilon</option>
                    </select>

                </c:when>
                <c:otherwise>

                    <label for="team">Team</label>
                    <select name="team" id="team">
                        <option value="alpha">alpha</option>
                        <option value="beta">beta</option>
                        <option value="gamma">gamma</option>
                        <option value="delta">delta</option>
                        <option value="epsilon">epsilon</option>
                    </select>
                </c:otherwise>
            </c:choose>

            <p><label for="date">Date</label>
                <input type="date" id="date" name="date" required value="${datePreviousValue}"></p>

            <p><label for="startTime">Starttime</label>
                <input type="date" id="startTime" name="startTime" required value="${startPreviousValue}"></p>

            <p><label for="endTime">Endtime</label>
                <input type="date" id="endTime" name="endTime" required value="${endPreviousValue}"></p>


            <p><input id="submit" type="submit" value="Registreer"></p>

        </form>
</main>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
