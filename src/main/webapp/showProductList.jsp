<%@ page import="ru.univeralex.web.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
    <% List<Product> products = (List<Product>) session.getAttribute("products");
        for (Product product : products) {%>
    <tr>
        <td><%out.println(product.getName());%></td>
        <td><%out.println(product.getCost());%></td>
    </tr>
    <%} %>
</table>
</html>