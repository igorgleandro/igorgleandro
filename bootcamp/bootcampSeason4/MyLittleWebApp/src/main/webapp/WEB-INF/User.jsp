<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 27/03/2024
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Java Bank - Homebank</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="tindercss.css">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <style>
        body {
            background-color: rgb(245, 212, 21);
        }
    </style>
</head>

<body>
<p></p>

<div class="card border-success mb-3" style="max-width: 18rem;" >
    <div class="card-header bg-transparent border-success">JavaBank S.A.</div>
    <div class="card-body text-success">
        <h5 class="card-title">Welcome ${customer.name}</h5>
        <p class="card-text">Email: ${customer.email}</p>
        <p class="card-text">Phone: ${customer.phone}</p>
    </div>
    <div class="card-footer bg-transparent border-success">All the rights reserved</div>
</div>

//Form

<form method="post" action="/myform/login">
    <p> Name: <input type="text" name="username"/> </p>
    <p> Password: <input type="password" name="password"/> </p>
    <p> <input type="submit" value="Login"/></p>
</form>

</body>
</html>
