<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 25.04.19
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie Twoje plany podróży</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="../../../media/css/style.css">
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

<div class="dashboardPageContainer" style="background-image: url(/media/images/P8316567); background-size: 100%">
    <div class="pageTitle">
        <h2 style="color: aqua;">LISTA DODANYCH PLANÓW PODRÓŻY</h2>
    </div>

    <div class="addPlaceForm">
        <form method="get" action="/travel-plan/add">
            <p style="color: aqua; font-size: 22px">Dodaj nowy plan podróży: <input type="submit" value="Dodaj"></p>
        </form>
    </div>
    <div class="placesList">
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th>Nazwa</th>--%>
<%--                <th>Opis</th>--%>
<%--            </tr>--%>
<%--        </table>--%>
        <ul>
            <c:forEach items="${plans}" var="plan">
                <li>
                    <table style="background-color: antiquewhite; opacity: 0.83;">
                        <tr>
<%--                            <input type="hidden" value="${plan.id}" name="planId"/>--%>
                            <td style="border: 1px solid black; color: black; padding: 8px"><strong>${plan.name}</strong></td>
                            <td style="border: 1px solid black; color: black; border-right: 2px solid red; padding: 8px">${plan.description}</td>
                            <c:forEach items="${plan.places}" var="place">
                                <td style="border: 1px solid black; color: black; border-left: 0px; padding: 8px">${place.name}<br>
                                </td>
                            </c:forEach>
                            <td>
                            <form method="get" action="/places/listAllPlaces">
                                <input type="submit" value="Dodaj miejsce">
                            </form>
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
