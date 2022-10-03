<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
	<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
	<div id="container">
		<header>
			<h2>
				<jsp:include page="loginStatus.jsp"/>
			</h2>
			<jsp:include page="nav.jsp"/>
			<h2>Home</h2>

		</header>
		<main> Sed ut perspiciatis unde omnis iste natus error sit
		voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
		ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
		dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
		aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
		qui ratione voluptatem sequi nesciunt. </main>

	</div>
	<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</body>
</html>