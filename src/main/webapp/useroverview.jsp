<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <jsp:include page="headPlusLoginStatus.jsp"/>
    <jsp:include page="nav.jsp"/>

<h2>
User Overview
</h2>

</header>
    <main>
        <table>
            <c:choose>
                <c:when test="${not empty useroverview}">
                    <h2>Users</h2>
                    <tr>
                        <th>User Id</th>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>

                    <c:forEach var="user" items="${useroverview}">
                        <tr>
                            <td>${user.userid}</td>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.team}</td>
                            <td>${user.role}</td>
                            <td><a href="Controller?command=EditForm&userid=${user.userid}">Edit</a></td>
                            <td><a href="Controller?command=DeleteConfirm&userid=${user.userid}">Delete</a></td>
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