<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>All users</title>
    <style>
        table { border-collapse: collapse; }
        th, td { border: 1px solid #ccc; padding: 6px 10px; }
    </style>
</head>
<body>

<h2>All users</h2>

<c:choose>
    <c:when test="${empty users}">
        <p>No users found.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Operationts</th>
                <th>Operationts</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">

                <c:url var="updateButton" value="/updateUser">

<c:param name="userId" value="${user.id}">

</c:param>
                    
                </c:url>

                <c:url var="deleteButton" value="/deleteUser">

                    <c:param name="userId" value="${user.id}"/>

                </c:url>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td><input type="button" value="update"
                    onclick="window.location.href='${updateButton}'"/>
                    <td><input type="button" value="delete"
                       onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<br>

<input type="button" value="add new users"

onclick="window.location.href = '/addNewUser'"

/>


</body>
</html>