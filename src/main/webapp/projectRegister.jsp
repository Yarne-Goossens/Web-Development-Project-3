<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<title>Project Register</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>

<h2>
    Register Project
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

        <form name="formulier" method="POST" action="Controller?command=ProjectRegisterProcessing" novalidate>

            <p><label for="projectName">Project Name</label>
                <input type="text" id="projectName" name="projectName" required value="${projectNamePreviousValue}"></p>

            <p><label for="start">Start date</label>
                <input type="date" id="start" name="start" required value="${startPreviousValue}"></p>

            <p><label for="end">End date</label>
                <input type="date" id="end" name="end" required value="${endPreviousValue}"></p>

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


            <p><input id="submit" type="submit" value="Registreer"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
