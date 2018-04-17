<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="wrapper">
    <form class="form" method="post" action="/login">
        <h2 class="form-heading">Please login</h2>
        <p><a href="signUp">Don't have an account?</a></p>
        <input type="text" class="form-control" id="name" name="name" placeholder="Username" required=""
               autofocus=""/>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>
        <input type="submit" value="Login" class="btn btn-lg btn-primary btn-block">
    </form>
</div>

</body>

</html>