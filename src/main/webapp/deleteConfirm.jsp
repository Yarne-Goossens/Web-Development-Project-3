<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Users</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<header>
    <h2>
        <jsp:include page="loginStatus.jsp"/>
    </h2>
    <jsp:include page="nav.jsp"/>
    <h2>
        User Overview
    </h2>
<body>
      Wilt u de persoon${tobeDeleted.firstName} ${tobeDeleted.lastName} met userid: ${tobeDeleted.userid} verwijderen?
      <br>
      <p><a href="Controller?command=DeleteProcessing&userid=${tobeDeleted.userid}">Ja</a></p>
      <br>
      <p><a href="Controller?command=Overview">Nee</a></p>

      <footer>
          &copy; Webontwikkeling 3, UC Leuven-Limburg
      </footer>
</body>
</html>
