<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 26.04.19
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plany naszych użytkowników</title>
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
<jsp:include page="../main/header.jsp"></jsp:include>

<div class="PageContainer">
    <div class="pageTitle" style="margin-top: 20px; margin-left: 200px;">
        <h2>LISTA DODANYCH PLANÓW PODRÓŻY</h2>
    </div>

    <div class="publicPlacesList">
        <table>
            <tr>
                <th>Nazwa</th>
                <th>Opis</th>
            </tr>
        </table>
        <ul>
            <c:forEach items="${publicPlans}" var="plan">
                <li>
                    <table class="listOfplans">
                        <tr>
                            <td style="border: 1px solid black; padding: 8px"><strong>${plan.name}</strong></td>
                            <td style="border: 1px solid black; border-right: 2px solid red; padding: 8px">${plan.description}</td>
                            <c:forEach items="${plan.places}" var="place">
                                <td style="border: 1px solid black; border-left: 0px; padding: 8px">${place.name}<br>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


<jsp:include page="../main/footer.jsp"></jsp:include>

</body>
</html>
