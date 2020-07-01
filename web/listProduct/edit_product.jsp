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
    <title>Title</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Number: </td>
                <td><input type="text" name="number" id="number" value="${requestScope["product"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color" id="color" value="${requestScope["product"].getColor()}"></td>
            </tr>
            <tr>
                <td>Dicserption : </td>
                <td><input type="text" name="discerption" id="discerption" value="${requestScope["product"].getDiscerption()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
