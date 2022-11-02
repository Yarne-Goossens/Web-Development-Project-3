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
<main>
    <table>
        <c:choose>
            <c:when test="${not empty workorderoverview}">
                <tr>
                    <th>Project Id</th>
                    <th>Name</th>
                    <th>Team</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach var="work" items="${workorderoverview}">
                    <tr>
                        <td><c:out value='${work.workorderId}'/></td>
                        <td><c:out value='${work.employee}'/></td>
                        <td><c:out value='${work.description}'/></td>
                        <td><c:out value='${work.date}'/></td>
                        <td><c:out value='${work.startTime}'/></td>
                        <td><c:out value='${work.endTime}'/></td>
                        <td><a id="edit" href="Controller?command=WorkorderEditForm&workorderid=<c:out value='${work.workorderId}'/>">Edit</a></td>
                        <td><a id="delete" href="Controller?command=ProjectDeleteConfirm&projectid=<c:out value='${work.workorderId}'/>">Delete</a></td>
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