<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Delete</title>
<jsp:include page="nav.jsp"></jsp:include>
<jsp:include page="headPlusLoginStatus.jsp"/>
<h2>
    Confirm deletion
</h2>
<body>
<p>Wilt u het project ${tobeDeleted.projectName} ${tobeDeleted.team} met projectid: ${tobeDeleted.projectId}
    verwijderen?</p>
<br>
<form name="formulierJa" method="POST"
      action="Controller?command=ProjectDeleteProcessing&projectid=<c:out value='${tobeDeleted.projectId}'/>"
      novalidate>
    <p><input id="submitJa" type="submit" value="Ja"></p>
</form>
<br>

<form name="formulierNee" method="POST" action="Controller?command=ProjectOverview" novalidate>
    <p><input id="submitNee" type="submit" value="Nee"></p>
</form>

<footer>
    &copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</body>
</html>
