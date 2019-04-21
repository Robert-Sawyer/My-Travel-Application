<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
File>Settings>File Templates
  User: michal
  Date: 2019-03-18
  Time: 07:27
--%>

<%-- <%@ include file="header.jsp" %> --%>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            <div id="mainLogo">
                <p class="logoText">SuperTramp Travel Logo</p>
            </div>
        </a>
        <ul class="nav nounderline text-uppercase">

            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="" />'>O aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="/contact" />'>Kontakt</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href='<c:url value="" />'>Plany</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href='<c:url value="/login" />'>Logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href='<c:url value="/register" />'>Rejestracja</a>
            </li>
        </ul>
    </nav>
</header>

