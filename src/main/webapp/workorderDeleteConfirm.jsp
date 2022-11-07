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
<p>Wilt u de workorder van ${tobeDeleted.employee} uit het ${tobeDeleted.team} team met workorderid: ${tobeDeleted.workorderId}
    verwijderen?</p>
<br>
<form name="formulierJa" method="POST"
      action="Controller?command=WorkorderDeleteProcessing&workorderid=<c:out value='${tobeDeleted.workorderId}'/>"
      novalidate>
    <p><input id="submitJa" type="submit" value="Ja"></p>
</form>
<br>

<form name="formulierNee" method="POST" action="Controller?command=WorkorderOverview" novalidate>
    <p><input id="submitNee" type="submit" value="Nee"></p>
</form>

<footer>
    &copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</body>
</html>
