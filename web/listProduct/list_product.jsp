<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 7/1/2020
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Danh sach san pham</h1>
<table>
    <tr>
        <td>name</td>
        <td>Price</td>
        <td>Color</td>
        <td>Number</td>
        <td>Discerption</td>
    </tr>

    <c:forEach items='${requestScope["productList"]}' var="product">
        <tr>
            <td>${student.getName()}</td>
            <td>${student.getPrice()}</td>
            <td>${student.getColor()}</td>
            <td>${student.getNumber()}</td>
            <td>${student.getDiscerption()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
