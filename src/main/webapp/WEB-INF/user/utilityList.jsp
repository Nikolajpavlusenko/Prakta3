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
<h1>Utility List</h1>
<div class="container">
    <section class="cart">
        <div class="row cart_item">

            <div class="col-6">
                <div class="customer" >Utility Name</div>
            </div>
            <div class="col-2">
                Price
            </div>
        </div>
    </section>
</div>
<div class="container">
    <section class="cart">
        <c:forEach items="${requestScope.items}" var="item">
            <div class="row cart_item">
                <div class="col-6">${item.name}</div>
                <div class="col-2"> ${item.price}</div>
                <div class="col-2">
                    <form action="order_create" method="post" >
                        <input type="hidden" name="utilityId" id="utilityId" value="${item.id}"/>
                        <input type="submit" class="btn btn-primary green-btn" value="Order">
                    </form>
                </div>
            </div>
        </c:forEach>

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