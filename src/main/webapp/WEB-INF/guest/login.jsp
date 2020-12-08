<!DOCTYPE HTML>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Utilities</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%--    <link rel="stylesheet"  href="../../static/test.css" type="text/css">--%>
    <style><%@include file="/resources/static/test.css"%></style>
</head>

<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-4 logo">
                <div >Utilities</div>
            </div>
            <div class="col-4 buttons">
            </div>
            <div class="col-4 logout">
            </div>
        </div>
    </div>
</header>

<nav class="menu">
    <div class="container">
        <ul>
            <li><a href="/web/" >Main</a></li>
            <li><a href="/web/login">Login</a></li>
            <li><a href="/web/registration">SignUp</a></li>
        </ul>
    </div>
</nav>
<section class="login">
    <form class="form-signin" method="post" action="log">
        <c:if test="${param.error != null}">
        <div class="alert alert-danger" role="alert">Invalid credentials</div>
        </c:if>
        <c:if test="${param.logout != null}">
        <div class="alert alert-info" role="alert">You have been logged out</div>
        </c:if>
        <c:if test="${param.user != null}">
            <div class="alert alert-danger" role="alert">You are already logged in</div>
        </c:if>
        <label for="email">Email</label>
        <input type="email" name="email" id="email" placeholder="ivanov@gmail.com">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="********">
        <input type="submit" value="Login" >
    </form>
</section>
<footer>
    <div class="container">
        <div class="row footer_info">
            <div class="col-4 footer-col logo">
                Utilities
            </div>

        </div>
    </div>
</footer>
</body>
</html>
