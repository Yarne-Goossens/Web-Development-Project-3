<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Edit</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>

<h2>
    Edit workorder
</h2>

<p>id: ${tobeEdited.workorderId}</p>

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


        <form name="formulier" method="POST"
              action="Controller?command=WorkorderEditProcessing&projectid=${tobeEdited.workorderId}" novalidate>

            <p><label for="employee">Employee</label>
                <input type="text" id="employee" name="employee" required value="${tobeEdited.employee}"></p>

            <label for="description">Description</label>
            <textarea id="description" name="description" required value="${tobeEdited.description}"></textarea>


            <label for="team">Team</label>
            <select name="team" id="team">
                <option value="${tobeEdited.team}">${tobeEdited.team}</option>
                <option value="alpha">alpha</option>
                <option value="beta">beta</option>
                <option value="gamma">gamma</option>
                <option value="delta">delta</option>
                <option value="epsilon">epsilon</option>
            </select>

            <p><label for="date">Date</label>
                <input type="date" id="date" name="date" required value="${tobeEdited.date}"></p>

            <p><label for="startTime">Starttime</label>
                <input type="date" id="startTime" name="startTime" required value="${tobeEdited.startTime}"></p>

            <p><label for="endTime">Endtime</label>
                <input type="date" id="endTime" name="endTime" required value="${tobeEdited.endTime}"></p>

            <p><input id="submit" type="submit" value="edit"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
