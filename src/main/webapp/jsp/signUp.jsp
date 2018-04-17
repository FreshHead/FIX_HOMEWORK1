<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/style.css">
</head>


<body>

<div class="wrapper">
    <form class="form" method="post" action="/signUp">
        <h2 class="form-heading">Please SignUp</h2>
        <p><a href="login">You already registered?</a></p>
        <input type="text" class="form-control" id="name" name="name" placeholder="Username" required=""
               autofocus=""/>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>
        <input type="submit" value="Sign Up" class="btn btn-lg btn-primary btn-block">
    </form>
    <div class="registered">
        <h2 class="form-heading">Registered users:</h2>
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