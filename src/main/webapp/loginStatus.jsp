<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${loginUserSession!=null}">
        <p>You are logged in as ${loginUserSession.firstName} ${loginUserSession.lastName}.</p>
    </c:when>
    <c:otherwise>
        <p>You are not logged in.</p>
    </c:otherwise>
</c:choose>
