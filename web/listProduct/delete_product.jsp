<%--
  Created by IntelliJ IDEA.
  User: BipVuong
  Date: 7/1/2020
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Number: </td>
                <td>${requestScope["product"].getNumber()}</td>
            </tr>
            <tr>
                <td>Color</td>
                <td>${requestScope["product"].getColr()}</td>
            </tr>
            <tr>
                <td>Dicserption</td>
                <td>${requestScope["product"].getDiscerption()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete student"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
