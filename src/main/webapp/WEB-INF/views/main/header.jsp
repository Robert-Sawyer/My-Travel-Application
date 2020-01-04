<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
    <div class="headerContainer">
        <div id="headerLogo">
            <a href="/">
                <div id="mainLogo">
                    <p class="logoText">SuperTramp Travel</p>
                </div>
            </a>
        </div>
        <div id="headerTopMenu">
            <ul id="headerMenuList">
                <li class="headerMenuListItem">
                    <a href='<c:url value="/dashboard" />'>O aplikacji</a>
                </li>
                <li class="headerMenuListItem">
                    <a href='<c:url value="/contact" />'>Kontakt</a>
                </li>
                <li class="headerMenuListItem">
                    <a href='<c:url value="/publicPlans" />'>Plany</a>
                </li>

                <sec:authorize access="!isAuthenticated()">
                    <li class="headerMenuListItem">
                        <a href='<c:url value="/login" />'>Logowanie</a>
                    </li>
                    <li class="headerMenuListItem">
                        <a href='<c:url value="/register" />'>Rejestracja</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="headerMenuListItem">
                        <a href='<c:url value="/dashboard"/>'>Kokpit</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
        <div style="clear: both"></div>
    </div>
</header>