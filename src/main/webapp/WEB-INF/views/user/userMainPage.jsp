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
        form.inline { display: inline; margin: 0; padding: 0; }
    </style>

    <!-- CSRF мета (удобно для AJAX) -->
    <c:if test="${not empty _csrf}">
        <meta name="_csrf" content="${_csrf.token}" />
        <meta name="_csrf_header" content="${_csrf.headerName}" />
    </c:if>
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
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">

                <c:url var="updateButton" value="/updateUser">
                    <c:param name="userId" value="${user.id}" />
                </c:url>

                <tr>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>


                    <td>
                        <input type="button" value="Update"
                               onclick="window.location.href='${pageContext.request.contextPath}${updateButton}'" />
                    </td>


                    <td>
                        <form class="inline" action="${pageContext.request.contextPath}/deleteUser" method="post">
                            <input type="hidden" name="userId" value="${user.id}" />
                            <c:if test="${not empty _csrf}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </c:if>
                            <button type="submit" onclick="return confirm('Удалить пользователя ${user.name}?');">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<br><br>

<!-- Добавление нового пользователя -->
<input type="button" value="Add new user" onclick="window.location.href='${pageContext.request.contextPath}/addNewUser'" />

</body>
</html>