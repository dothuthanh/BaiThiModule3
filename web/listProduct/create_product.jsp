<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 7/1/2020
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new students</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Number </td>
                <td><input type="text" name="number" id="number"></td>
            </tr>
            <tr>
                <td>Color </td>
                <td><input type="text" name="color" id="color"></td>
            </tr>
            <tr>
                <td>Discerption </td>
                <td><input type="text" name="discerption" id="discerption"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"><a href="/products"></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
