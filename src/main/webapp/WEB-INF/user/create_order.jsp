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
<h1>Create order</h1>
<div class="container">
    <section class="login">
        <form action="addOrderToPayment" method="post">
            <input type="text" name="utilityId" id="utilityId" value="${requestScope.utility.id}" hidden>
            <label for="name1">Utility</label>
            <input type="text" name="name1" id="name1" placeholder="${requestScope.utility.name}" disabled>
            <input type="text" name="name" id="name" value="${requestScope.utility.name}" hidden>
            <label for="price1">Price</label>
            <input type="number" name="price1" id="price1" placeholder="${requestScope.utility.price}" disabled>
            <input type="number" name="price" id="price" value="${requestScope.utility.price}" hidden>
            <label for="amount">Amount</label>
            <input type="number" name="amount" id="amount" placeholder="3" required>
            <label for="date">Date</label>
            <input type="date" name="date" id="date" placeholder="" required>
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