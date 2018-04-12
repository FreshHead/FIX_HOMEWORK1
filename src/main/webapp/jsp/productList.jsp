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
        <th>Name</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
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
    <input type="submit" value="Add product">
</form>
<p><a href="/officeList">Wanna find our office?</a></p>
</html>