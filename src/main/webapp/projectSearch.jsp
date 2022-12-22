<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Search Project</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>

<h2>
    Search for project
</h2>

</header>
<main>
    <div>
        <c:if test="${not empty errors}">
        <div id="error" class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
            </c:if>
        </div>


        <form name="formulier" method="POST" action="Controller?command=ProjectSearchProcessing"
              novalidate>

            <p><label for="projectName">Project Name</label>
                <input type="text" id="projectName" name="projectName" required></p>


            <p><input id="submit" type="submit" value="Search"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
