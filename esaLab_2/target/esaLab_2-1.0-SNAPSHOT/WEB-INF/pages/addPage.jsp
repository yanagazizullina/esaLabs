<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<c:url value="/add" var="var"/>
<form action="${var}" method="POST">

    <label for="name">Id</label>
     <input type="text" name="id" id="id">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">

    <label for="genus">Genus</label>
    <input type="text" name="genus" id="genus">

    <label for="lighting">Lighting</label>
    <input type="text" name="lighting" id="lighting">

    <label for="watering">Watering</label>
    <input type="text" name="watering" id="watering">

    <label for="temperature">Temperature</label>
    <input type="text" name="temperature" id="temperature">
    <p>
        <c:set value="add" var="add"/>
        <input type="submit" value="add">
    </p>
</form>
</body>
</html>