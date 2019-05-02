<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 19.04.19
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista wszystkich miejsc</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="../../media/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="sidenav">
    <a href='<c:url value="/dashboard"/>'>Kokpit</a>
    <a href='<c:url value="/travel-plan/listAllPlans"/>'>Plany</a>
    <a href='<c:url value="/places/listAllPlaces"/>'>Miejsca</a>
    <a href="#">Edytuj dane</a>
    <a href='<c:url value="/logout"/>'>Wyloguj</a>
</div>
<div class="dashboardPageContainer" style="background-size: 100%; background-image: url(/media/images/P9046627)">
    <div class="pageTitle">
        <h2 style="color: white;">LISTA DODANYCH MIEJSC</h2>
    </div>
    <div class="findPlace">
        <form:form modelAttribute="placeName" method="post">
            <p style="color: white; font-size: 22px;">Wyszukaj miejsce: <form:input path="name"/></p>
            <input type="submit" value="Szukaj" name="search"/>
        </form:form>
        <%--        <form:form>--%>
        <%--        Wyszukaj miejsce: <form:input path="search"/>--%>
        <%--            <input type="submit" value="Wyszukaj">--%>
        <%--        </form:form>--%>
    </div>
    <div class="addPlaceForm">
        <form method="get" action="/places/add">
            <p style="color: white; font-size: 22px;">Dodaj nowe miejsce: <input type="submit" value="Dodaj"></p>
        </form>
    </div>
    <div class="placesList">
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th>Nazwa</th>--%>
<%--                <th>Kraj</th>--%>
<%--                <th>Miasto</th>--%>
<%--                <th>Opis</th>--%>
<%--            </tr>--%>
<%--        </table>--%>
        <ul>
            <c:forEach items="${places}" var="place">
                <li>
                    <table style="color: white;">
                        <tr>
                            <td>${place.name}</td>
                            <td>${place.country}</td>
                            <td>${place.city}</td>
                            <td>${place.description}</td>
                            <td>
                                <form:form modelAttribute="addPlaceToPlan" method="post">
                                    <select name="planId">
                                        <c:forEach items="${plans}" var="plan">
                                            <c:if test="${!plan.places.contains(place)}">
                                                <option value="${plan.id}">${plan.name}</option>
                                            </c:if>
                                        </c:forEach>
                                        <input type="hidden" value="${place.id}" name="placeId"/>
                                        <input type="submit" value="Dodaj do planu" name="addToPlan"/>
                                    </select>
                                </form:form>
                            </td>
                        </tr>
                    </table>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>
