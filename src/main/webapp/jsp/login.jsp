<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="wrapper">
    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">Please login</h2>
        <input type="text" class="form-control" id="name" name="name" placeholder="Username" required=""
               autofocus=""/>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>
        <input type="submit" value="Login" class="btn btn-lg btn-primary btn-block">
    </form>
</div>

</body>

</html>