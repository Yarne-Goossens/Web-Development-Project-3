<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<div id="container">
<h1><span>XXX</span></h1>
<jsp:include page="nav.jsp"/>
<h2>
    Login
</h2>
<form name="formulier" method="POST" action="Controller?command=LoginProcessing" novalidate>
    <label for="name">Naam: </label>
    <input type="text" id="name" name="name"  placeholder="Jan Janssens">

    <label for="name">Wachtwoord: </label>
    <input type="password" id="password" name="password">

    <input id = "submit" type = "submit" name="command" value="edit">
</form>
</div>
<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</body>
</html>
