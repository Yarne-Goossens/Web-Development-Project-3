<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<title>User Overview</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>
<h2>
    User Overview
</h2>

</header>
<main>
    <table>
        <c:choose>
            <c:when test="${not empty useroverview}">
                <tr>
                    <th>User Id</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Name</th>
                    <th>Team</th>
                    <th>Role</th>
                    <c:if test="${user.role=='EMPLOYEE'||user.role=='TEAMLEADER'||user.role=='DIRECTOR'}">
                        <th>Edit</th>
                    </c:if>
                    <c:if test="${user.role=='DIRECTOR'}">
                        <th>Delete</th>
                    </c:if>
                </tr>

                <c:forEach var="userview" items="${useroverview}">
                    <tr>
                        <td><c:out value='${userview.userid}'/></td>
                        <td><c:out value='${userview.email}'/></td>
                        <td><c:out value='${userview.firstName}'/></td>
                        <td><c:out value='${userview.lastName}'/></td>
                        <td><c:out value='${userview.team}'/></td>
                        <td><c:out value='${userview.role}'/></td>
                        <c:if test="${user.role=='EMPLOYEE'&&user.userid==userview.userid||user.role=='TEAMLEADER'&&user.team==userview.team||user.role=='DIRECTOR'}">
                            <td><a id="edit"
                                   href="Controller?command=UserEditForm&userid=<c:out value='${userview.userid}'/>">Edit</a>
                            </td>
                        </c:if>
                        <c:if test="${user.role=='DIRECTOR'}">
                            <td><a id="delete"
                                   href="Controller?command=UserDeleteConfirm&userid=<c:out value='${userview.userid}'/>">Delete</a>
                            </td>
                        </c:if>
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