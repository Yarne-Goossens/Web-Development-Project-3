<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Register</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<div id="container">
    <header>
        <h2>
            <jsp:include page="loginStatus.jsp"/>
        </h2>

        <jsp:include page="nav.jsp"/>
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


        <form name="formulier" method="POST" action="Controller?command=EditProcessing&userid=${tobeEdited.userid}" novalidate>

            <p><label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" required value=""> </p>

            <p><label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required> </p>

            <p><label for="email">Email</label>
                <input type="email" id="email" name="email" required></p>

            <label for="role">Role</label>
            <select name="role" id="role">
                <option value="employee">user</option>
                <option value="teamleader">coordinator</option>
                <option value="director">admin</option>
            </select>


            <label for="team">Team</label>
            <select name="team" id="team">
                <option value="alpha">alpha</option>
                <option value="beta">beta</option>
                <option value="gamma">gamma</option>
                <option value="delta">delta</option>
                <option value="epsilon">epsilon</option>
            </select>

            <p><input id = "submit" type = "submit" value="edit"></p>

        </form>
</main>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</body>
</html>
