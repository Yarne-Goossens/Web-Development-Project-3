<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="headPlusLoginStatus.jsp"/>
    <jsp:include page="nav.jsp"/>
    <h2>
        Confirm deletion
    </h2>
<body>
    <p>Wilt u de persoon${tobeDeleted.firstName} ${tobeDeleted.lastName} met userid: ${tobeDeleted.userid} verwijderen?</p>
      <br>
      <form name="formulierJa" method="POST" action="Controller?command=DeleteProcessing&userid=${tobeDeleted.userid}" novalidate>
          <p><input id = "submitJa" type = "submit" value="Ja"></p>
      </form>
      <br>

      <form name="formulierNee" method="POST" action="Controller?command=Overview" novalidate>
          <p><input id = "submitNee" type = "submit" value="Nee"></p>
      </form>

      <footer>
          &copy; Webontwikkeling 3, UC Leuven-Limburg
      </footer>
</body>
</html>
