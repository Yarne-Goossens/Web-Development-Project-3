<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Project Overview</title>
    <jsp:include page="nav.jsp"></jsp:include>
    <jsp:include page="headPlusLoginStatus.jsp"/>
</head>
<body>

</header>
<main>
    <table>
        <c:choose>
            <c:when test="${not empty projectoverview}">
                <tr>
                    <th>Project Id</th>
                    <th>Name</th>
                    <th>Team</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach var="project" items="${projectoverview}">
                    <tr>
                        <td><c:out value='${project.userid}'/></td>
                        <td><c:out value='${project.email}'/></td>
                        <td><c:out value='${project.firstName}'/></td>
                        <td><c:out value='${project.lastName}'/></td>
                        <td><c:out value='${project.team}'/></td>
                        <td><c:out value='${project.role}'/></td>
                        <td><a id="edit" href="Controller?command=EditForm&userid=<c:out value='${project.userid}'/>">Edit</a></td>
                        <td><a id="delete" href="Controller?command=DeleteConfirm&userid=<c:out value='${project.userid}'/>">Delete</a></td>
                    </tr>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <p>There are no user to show.</p>
            </c:otherwise>
        </c:choose>
    </table>
</main>
<footer>
    &copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</body>
</html>