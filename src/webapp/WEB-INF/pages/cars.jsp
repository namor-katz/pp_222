<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 19.04.20
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>


<div align="center">
<table border="1" cellpadding="5">
<caption>List Cars</caption>
<tr>
    <th>Vendor</th>
    <th>Models</th>
    <th>Date manufactur</th>
</tr>
<c:forEach var="car" items="${listCars}">
    <tr>
    <td><c:out value="${car.vendor}" /></td>
    <td><c:out value="${car.model}" /></td>
    <td><c:out value="${car.ageMake}" /></td>
    <td>
    </td>

    </tr>
    </c:forEach>

</body>
    </html>
