<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Work Overview</title>
    <jsp:include page="nav.jsp"></jsp:include>
    <jsp:include page="headPlusLoginStatus.jsp"/>
</head>
<body>

</header>
<div id="functions">
    <a id="search" href="Controller?command=WorkorderSearch">Search for a workorder</a>
    Order By: <a href="Controller?command=OrderByEmployee">Employee</a>
</div>
<main>
    <table>
        <c:choose>
            <c:when test="${not empty workorderoverview}">
                <tr>
                    <th>Workorder Id</th>
                    <th>Employee</th>
                    <th>Employee Id</th>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Duration</th>
                    <c:if test="${user.role=='EMPLOYEE'&&user.userid==work.userId||user.role=='TEAMLEADER'||user.role=='DIRECTOR'}">
                        <th>Edit</th>
                    </c:if>
                    <c:if test="${user.role=='DIRECTOR'}">
                        <th>Delete</th>
                    </c:if>
                </tr>

                <c:forEach var="work" items="${workorderoverview}">
                    <tr>
                        <td><c:out value='${work.workorderId}'/></td>
                        <td><c:out value='${work.employee}'/></td>
                        <td><c:out value='${work.userId}'/></td>
                        <td><c:out value='${work.description}'/></td>
                        <td><c:out value='${work.date}'/></td>
                        <td><c:out value='${work.startTime}'/></td>
                        <td><c:out value='${work.endTime}'/></td>
                        <td><c:out value='${work.getDuration()}'/></td>
                        <c:if test="${user.role=='EMPLOYEE'&&user.userid==work.userId||user.role=='TEAMLEADER'&&user.team==work.team||user.role=='DIRECTOR'}">
                            <td><a id="edit"
                                   href="Controller?command=WorkorderEditForm&workorderid=<c:out value='${work.workorderId}'/>">Edit</a>
                            </td>
                        </c:if>
                        <c:if test="${user.role=='DIRECTOR'}">
                            <td><a id="delete"
                                   href="Controller?command=WorkorderDeleteConfirm&workorderid=<c:out value='${work.workorderId}'/>">Delete</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <p>There are no workorders to show.</p>
            </c:otherwise>
        </c:choose>
    </table>
</main>
<footer>
    &copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</body>
</html>