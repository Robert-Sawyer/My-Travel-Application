<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
    <div id="headerLogo">
        <a href="/">
            <p class="logoText">SuperTramp Travel</p>
        </a>
    </div>
    <div id="headerMenuContainer">
        <div id="headerMenu">
            <div class="headerMenuItem">
                <a href='<c:url value="/dashboard" />'>O aplikacji</a>
            </div>
            <div class="headerMenuItem">
                <a href='<c:url value="/contact" />'>Kontakt</a>
            </div>
            <div class="headerMenuItem">
                <a href='<c:url value="/publicPlans" />'>Plany</a>
            </div>

            <sec:authorize access="!isAuthenticated()">
                <div class="headerMenuItem">
                    <a href='<c:url value="/login" />'>Logowanie</a>
                </div>
                <div class="headerMenuItem">
                    <a href='<c:url value="/register" />'>Rejestracja</a>
                </div>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="headerMenuItem">
                    <a href='<c:url value="/dashboard"/>'>Kokpit</a>
                </div>
            </sec:authorize>
            <div style="clear: both"></div>
        </div>
    </div>
    <div style="clear: both"></div>
</header>