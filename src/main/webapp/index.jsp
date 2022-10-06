<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <jsp:include page="headPlusLoginStatus.jsp"/>
    <jsp:include page="nav.jsp"/>

        <h2>
            Login
        </h2>
    </header>
    <c:if test="${not empty errors}">
    <div id="error" class="alert alert-danger">
        <ul>
            <c:forEach items="${errors}" var="error">
                <li>${error}</li>
            </c:forEach>
        </ul>
        </c:if>
    <c:choose>
        <c:when test="${empty loginUserSession}">

    <form name="login" method="POST" action="Controller?command=LoginProcessing" novalidate>

        <label for="email">Email: </label>
        <input type="text" id="email" name="email" placeholder="Jan.Janssens@gmail.com">

        <label for="password">Wachtwoord: </label>
        <input type="password" id="password" name="password">

        <input id="submit" type="submit" name="command" value="login">
    </form>
        </c:when>
        <c:otherwise>
            <p>Welcome, ${loginUserSession.firstName}!</p>
            <form name="logout" method="POST" action="Controller?command=LogoutProcessing" novalidate>
                <input id="submitLogout" type="submit" name="command" value="logout">
            </form>
        </c:otherwise>
    </c:choose>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
