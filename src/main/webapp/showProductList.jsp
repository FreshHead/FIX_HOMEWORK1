<%@ page import="ru.univeralex.web.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<%
    List<Product> products = (List<Product>) session.getAttribute("products");
    for (Product product : products) {
        out.println(product.toString());
    }
%>

</body>
</html>