<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<h1>Overview</h1>
</body>
<table>
    <tr>
        <th>Name</th>
        <th>Radius (km)</th>
        <th>Mass (kg)</th>
        <th>Semimajor Axis (m)</th>
        <th>Type of planet</th>
        <th>Type of sun</th>
        <th>Orbital Period (earth days)</th>
        <th>Orbital Velocity (km/s)</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>

    <tr>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td>test</td>
        <td><a>Edit</a></td>
        <td><a>Delete</a></td>
    </tr>
</table>
</html>