<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 16.04.19
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Twój Kokpit</title>
    <link rel="stylesheet" href="../../../media/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="sidenav">
    <a href='<c:url value="/dashboard" />'>Kokpit</a>
    <a href='<c:url value="/travel-plan/listAllPlans" />'>Plany</a>
    <a href='<c:url value="/places/listAllPlaces" />'>Miejsca</a>
    <a href="#">Edytuj dane</a>
    <a href='<c:url value="/logout"/>'>Wyloguj</a>
</div>
<div class="dashboardPageContainer">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="/places/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">DODAJ NOWE MIEJSCE</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/travel-plan/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">DODAJ NOWY PLAN</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/places/listAllPlaces">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">DODAJ MIEJSCE DO PLANU</span>
                </a>
            </div>
        </div>

<%--        <div class="dashboard-alerts">--%>
<%--            <div class="alert-item alert-light">--%>
<%--                <i class="far icon-calendar fa-calendar-alt"></i>--%>
<%--                <span class="font-weight-bold">Liczba planów: </span>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
