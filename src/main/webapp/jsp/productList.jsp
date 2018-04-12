<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.cost}</td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="/productList">
    <label for="name">Product name
        <input class="input-field" type="text" id="name" name="name">
    </label>
    <label for="cost">Product cost
        <input class="input-field" type="text" id="cost" name="cost">
    </label>
    <input type="submit" value="Add product" name="add">
</form>

<form method="post" action="/productList">
    <label for="id">Product id
        <input class="input-field" type="text" id="id" name="id">
    </label>
    <input type="submit" value="Delete product" name="delete">
</form>

<form method="post" action="/productList">
    <label for="id">Product id
        <input class="input-field" type="text" name="id">
    </label>
    <label for="name">Product name
        <input class="input-field" type="text" name="name">
    </label>
    <label for="cost">Product cost
        <input class="input-field" type="text" name="cost">
    </label>
    <input type="submit" value="Update product" name="update">
</form>

<p><a href="/officeList">Wanna find our office?</a></p>
</html>