<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Edit</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>

<h2>
    Edit user
</h2>

<p>id: ${tobeEdited.userid}</p>

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


        <form name="formulier" method="POST" action="Controller?command=UserEditProcessing&userid=${tobeEdited.userid}"
              novalidate>

            <p><label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" required value="${tobeEdited.firstName}"></p>

            <p><label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required value="${tobeEdited.lastName}"></p>

            <p><label for="email">Email</label>
                <input type="email" id="email" name="email" required value="${tobeEdited.email}"></p>


            <label for="role">Role</label>
            <select name="role" id="role">
                <option value="${tobeEdited.role}">${tobeEdited.role}</option>
                <option value="employee">employee</option>
                <option value="teamleader">teamleader</option>
                <option value="director">director</option>
            </select>


            <label for="team">Team</label>
            <select name="team" id="team">
                <option value="${tobeEdited.team}">${tobeEdited.team}</option>
                <option value="alpha">alpha</option>
                <option value="beta">beta</option>
                <option value="gamma">gamma</option>
                <option value="delta">delta</option>
                <option value="epsilon">epsilon</option>
            </select>

            <p><input id="submit" type="submit" value="edit"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</body>
</html>
