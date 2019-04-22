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
<html>
<head>
    <title>Rejestracja</title>
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
<div class="bodyContainer">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="pageContainer">
        <div class="registerPageTitle">
            <h2>REJESTRACJA</h2>
        </div>
        <div class="formContainer">

            <form:form modelAttribute="registrationForm" method="post">
                <form:errors path="*"/><br>
                Login: <form:input path="login"/><br>
                E-mail: <form:input path="email"/><br>
                <%--    Imię: <form:input path="firstName"/><br>--%>
                <%--    nazwisko: <form:input path="lastName"/><br>--%>
                Hasło: <form:password path="password"/><br>
                Powtórz hasło: <form:password path="confirmPassword"/><br>
                <input type="submit" class="btn btn-danger" value="Zarejestruj"/>

            </form:form>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
