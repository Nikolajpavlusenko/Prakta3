<!DOCTYPE HTML>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Utilities</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
                <div>
                        <div class="name">${sessionScope.user.name}</div>
                        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/web/logout'">LogOut</button>
                </div>
            </div>
        </div>
    </div>
</header>
<nav class="menu">
    <div class="container">
        <ul>
            <li><a href="/web/user/order_utility" >Choose Utility</a></li>
        </ul>
    </div>
</nav>
<h1>Submit Order</h1>
<div class="container">
    <section class="login">
        <form action="order_utility" method="post">
            <label for="name">Utility</label>
            <input type="text" name="name" id="name" placeholder="${requestScope.utilityName}" disabled>
            <label for="price">Price</label>
            <input type="number" name="price" id="price" placeholder="${requestScope.utilityPrice}" disabled>
            <label for="amount">Amount</label>
            <input type="number" name="amount" id="amount" placeholder="${requestScope.payment.amount}" disabled>
            <label for="date">Date</label>
            <input type="date" name="date" id="date" value="${requestScope.payment.date}" disabled>
            <label for="sum">Sum</label>
            <input type="number" name="sum" id="sum" placeholder="${requestScope.payment.price}" disabled>
            <input type="submit" value="Submit">
        </form>
    </section>
</div>

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