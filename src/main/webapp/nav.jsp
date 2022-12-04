<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <c:set var="url" scope="session" value="${requestScope['javax.servlet.forward.query_string']}"/>
        <c:choose>
            <c:when test="${not empty url}">
                <li><a href="Controller?command=Home" ${url.contains("command=Home")?"class='active'":""}>Home</a></li>
                <li><a href="Controller?command=UserOverview" ${url.contains("command=UserOverview")?"class='active'":""}>User Overview</a></li>
                <li><a href="Controller?command=UserRegister" ${url.contains("command=UserRegister")?"class='active'":""}>Register User</a></li>
                <li><a href="Controller?command=ProjectOverview" ${url.contains("command=ProjectOverview")?"class='active'":""}>Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister" ${url.contains("command=ProjectRegister")?"class='active'":""}>Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview" ${url.contains("command=WorkorderOverview")?"class='active'":""}>Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister" ${url.contains("command=WorkorderRegister")?"class='active'":""}>Workorder Register</a></li>

            </c:when>

            <c:otherwise>
                <li><a href="index.jsp" class="active">Home</a></li>
                <li><a href="Controller?command=UserOverview">User Overview</a></li>
                <li><a href="Controller?command=UserRegister">Register User</a></li>
                <li><a href="Controller?command=ProjectOverview">Project Overview</a></li>
                <li><a href="Controller?command=ProjectRegister">Project Register</a></li>
                <li><a href="Controller?command=WorkorderOverview">Workorder Overview</a></li>
                <li><a href="Controller?command=WorkorderRegister">Workorder Register</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

