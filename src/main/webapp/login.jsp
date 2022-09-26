<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<h1>Login</h1>

<form name="formulier" method="POST" action="Controller?command=LoginProcessing" novalidate>
    <label for="name">Naam: </label>
    <input type="text" id="name" name="name"  placeholder="Jan Janssens">

    <label for="name">Wachtwoord: </label>
    <input type="password" id="password" name="password">

    <input id = "submit" type = "submit" name="command" value="edit">
</form>
</body>
</html>
