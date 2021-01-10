<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Plants</title>
<body>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Genus</td>
        <td>Lighting</td>
        <td>Watering</td>
        <td>Temperature</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${plantsList}" var="plant">
        <tr>
            <td>${plant.id}</td>
            <td>${plant.name}</td>
            <td>${plant.genus.name}</td>
            <td>${plant.lighting}</td>
            <td>${plant.watering}</td>
            <td>${plant.temperature}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
