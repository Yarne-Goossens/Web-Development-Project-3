<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <c:set var="url" scope="session" value="${requestScope['javax.servlet.forward.query_string']}"/>
        <c:choose>
            <c:when test="${url=='command=UserOverview'}">
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="Controller?command=UserOverview">User Overview</a></li>
                <li><a href="Controller?command=UserRegister">Register User</a></li>
                <li><a href="Controller?command=ProjectOverview">Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister">Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview">Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister">Workorder Register</a></li>
            </c:when>

            <c:when test="${url=='command=Register'||url=='command=RegisterProcessing'}">
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="Controller?command=UserOverview">User Overview</a></li>
                <li><a href="Controller?command=UserRegister">Register User</a></li>
                <li><a href="Controller?command=ProjectOverview">Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister">Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview">Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister">Workorder Register</a></li>
            </c:when>

            <c:when test="${empty url}">
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="Controller?command=UserOverview">User Overview</a></li>
                <li><a href="Controller?command=UserRegister">Register User</a></li>
                <li><a href="Controller?command=ProjectOverview">Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister">Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview">Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister">Workorder Register</a></li>
            </c:when>

            <c:otherwise>
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="Controller?command=UserOverview">User Overview</a></li>
                <li><a href="Controller?command=UserRegister">Register User</a></li>
                <li><a href="Controller?command=ProjectOverview">Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister">Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview">Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister">Workorder Register</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

