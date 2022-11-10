<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Edit</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>

<h2>
    Edit project
</h2>

<p>id: ${tobeEdited.projectId}</p>

</header>
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


        <form name="formulier" method="POST" action="Controller?command=ProjectEditProcessing&projectid=<c:out value='${tobeEdited.projectId}'/>" novalidate>

            <p><label for="projectName">Project name</label>
                <input type="text" id="projectName" name="projectName" required value="${tobeEdited.projectName}"></p>

            <p><label for="start">Start date</label>
                <input type="date" id="start" name="start" required value="${tobeEdited.start}"></p>

            <p><label for="end">End date</label>
                <input type="date" id="end" name="end" required value="${tobeEdited.end}"></p>

            <label for="team">Team</label>
            <select name="team" id="team">
                <option value="${tobeEdited.team}">${tobeEdited.team}</option>
                <option value="alpha">alpha</option>
                <option value="beta">beta</option>
                <option value="gamma">gamma</option>
                <option value="delta">delta</option>
                <option value="epsilon">epsilon</option>
            </select>

            <p><input id="submit" type="submit" value="edit"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
