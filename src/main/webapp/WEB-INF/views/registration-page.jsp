<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 15.04.19
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form:form modelAttribute="registrationForm" method="post">
    <form:errors path="*"/><br>
    Login: <form:input path="login"/><br>
    Imię: <form:input path="firstName"/><br>
    nazwisko: <form:input path="lastName"/><br>
    hasło: <form:password path="password"/><br>
    powtó©z hasło: <form:password path="confirmPassword"/><br>
    <input type="submit" class="btn btn-danger" value="Zarejestruj"/>

</form:form>

</body>
</html>
