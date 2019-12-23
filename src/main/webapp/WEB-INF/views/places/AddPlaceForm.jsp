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
    <title>Dodaj nowe miejsce</title>
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
<jsp:include page="../main/header.jsp"></jsp:include>
<div class="sidenav">
    <a href='<c:url value="/dashboard"/>'>Kokpit</a>
    <a href='<c:url value="/travel-plan/listAllPlans"/>'>Plany</a>
    <a href='<c:url value="/places/listAllPlaces"/>'>Miejsca</a>
    <a href="#">Edytuj dane</a>
    <a href='<c:url value="/logout"/>'>Wyloguj</a>
</div>
<div class="pageContainer" style="background-size: 100%; background-image: url(/media/images/P4206676)">

    <div class="registerPageTitle">
        <h2>DODAJ NOWE MIEJSCE</h2>
    </div>
    <div class="formContainer" style="margin-top: 20px; margin-top: 20px; background-color: antiquewhite; opacity: 0.83;">
        <form:form method="post" modelAttribute="place">
            <form:errors path="*"/><br>
            Nazwa miejsca: <form:input path="name"/><br>
            Kraj: <form:input path="country"/><br>
            Miasto: <form:input path="city"/><br>
            Opis:  <form:input path="description"/><br>
            <input type="submit" value="Dodaj">

        </form:form>
    </div>
</div>
<jsp:include page="../main/footer.jsp"></jsp:include>

</body>
</html>
