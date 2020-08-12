<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 6/24/2020
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search User</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=list">List Product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Search Product</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Search"/>
                </td>
            </tr>
            <c:forEach var="product" items="${requestScope.product}">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.number}"/></td>
                    <td><c:out value="${product.color}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.category}"/></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
