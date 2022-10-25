<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <c:set var="url" scope="session" value="${requestScope['javax.servlet.forward.query_string']}"/>
        <c:choose>
            <c:when test="${url=='command=Overview'}">
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="Controller?command=Overview">Users</a></li>
                <li><a href="Controller?command=Register">Register</a></li>
            </c:when>

            <c:when test="${url=='command=Register'}">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Controller?command=Overview">Users</a></li>
                <li><a class="active" href="Controller?command=Register">Register</a></li>
            </c:when>

            <c:otherwise>
                <li><a class="active" href="index.jsp">Home</a></li>
                <li><a href="Controller?command=Overview">Users</a></li>
                <li><a href="Controller?command=Register">Register</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

