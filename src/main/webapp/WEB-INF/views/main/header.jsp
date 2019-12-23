<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            <div id="mainLogo">
                <p class="logoText">SuperTramp Travel</p>
            </div>
        </a>
        <ul class="nav nounderline text-uppercase">

            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="/dashboard" />'>O aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="/contact" />'>Kontakt</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="/publicPlans" />'>Plany</a>
            </li>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href='<c:url value="/login" />'>Logowanie</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href='<c:url value="/register" />'>Rejestracja</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href='<c:url value="/dashboard"/>'>Kokpit</a>
                </li>
            </sec:authorize>
        </ul>
    </nav>
</header>
