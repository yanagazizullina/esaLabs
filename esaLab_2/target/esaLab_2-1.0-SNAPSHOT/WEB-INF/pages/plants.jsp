<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Plants</title>
    <head>
        <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    </head>
</head>
<body>

<h2 align="center">Plants</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Genus</th>
        <th>Lighting</th>
        <th>Watering</th>
        <th>Temperature</th>
    </tr>
    <c:forEach var="plant" items="${plantsList}">
        <tr>
            <td>${plant.id}</td>
            <td>${plant.name}</td>
            <td>${plant.genus}</td>
            <td>${plant.lighting}</td>
            <td>${plant.watering}</td>
            <td>${plant.temperature}</td>
            <td>
                <a href="/edit/${plant.id}">edit</a>
                <a href="/delete/${plant.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>


<p align="center">
    <c:url value="/add" var="add"/>
<a href="${add}">Add new plant</a>
</p>>
</body>
</html>