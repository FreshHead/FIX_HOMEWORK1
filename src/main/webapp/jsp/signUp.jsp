<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%--<head>--%>
<%--<title>Title</title>--%>
<%--&lt;%&ndash;<link href="/css/styles.css" rel="stylesheet" type="text/css">&ndash;%&gt;--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="form-style-2">--%>
<%--<div class="form-style-2-heading">--%>
<%--Please Sign Up!--%>
<%--<p><a href="/login">Already registered?</a></p>--%>
<%--</div>--%>
<%--<form method="post" action="/signUp">--%>
<%--<label for="name">User name--%>
<%--<input class="input-field" type="text" id="name" name="name">--%>
<%--</label>--%>
<%--<label for="password">Password--%>
<%--<input class="input-field" type="password" id="password" name="password">--%>
<%--</label>--%>
<%--<input type="submit" value="Sign Up">--%>
<%--</form>--%>
<%--</div>--%>

<%--<div class="form-style-2">--%>
<%--<div class="form-style-2-heading">--%>
<%--This people already registered:--%>
<%--</div>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<th>User name</th>--%>
<%--<th>Birth Date</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${usersFromServer}" var="user">--%>
<%--<tr>--%>
<%--<td>${user.name}</td>--%>
<%--<td>${user.registrationDate}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</div>--%>
<%--</body>--%>

<head>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/style.css">
</head>


<body>

<div class="wrapper">
    <form class="form-signin"  method="post" action="/signUp">
        <h2 class="form-signin-heading">Please SignUp</h2>
        <p><a href="/login">You already registered?</a></p>
        <input type="text" class="form-control" id="name" name="name" placeholder="Username" required=""
               autofocus=""/>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>
        <input type="submit" value="Sign Up" class="btn btn-lg btn-primary btn-block">
    </form>
    <div class="registered">
        <h2 class="form-signin-heading">Registered users:</h2>
    <table>
        <tr>
            <th>User name</th>
            <th>Registration date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.registrationDate}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</div>

</body>
</html>