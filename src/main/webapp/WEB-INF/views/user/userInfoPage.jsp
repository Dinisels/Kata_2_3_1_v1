<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>User form</title>
</head>
<body>

<h2>Add / Edit user</h2>

<c:choose>
    <c:when test="${empty user.id}">
        <c:set var="formAction" value="${pageContext.request.contextPath}/createUser" />
    </c:when>
    <c:otherwise>
        <c:set var="formAction" value="${pageContext.request.contextPath}/updateUser" />
    </c:otherwise>
</c:choose>

<form:form action="${formAction}" modelAttribute="user" method="post">
    <form:hidden path="id" />

    <div>
        <label>name</label>
        <form:input path="name" />
    </div>
    <br/>
    <div>
        <label>age</label>
        <form:input path="age" />
    </div>
    <br/>
    <div>
        <label>email</label>
        <form:input path="email" />
    </div>
    <br/>

    <c:if test="${not empty _csrf}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </c:if>

    <input type="submit" value="Save" />
    <input type="button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/userAll'" />
</form:form>

</body>
</html>