<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>
    Add new user form
</h2>
<br>

<form:form action="/saveUser" modelAttribute="user">

    <form:hidden path="id"/>

    name <form:input path = "name"/>
    <br><br>
    age <form:input path = "age"/>
    <br><br>
    email <form:input path = "email"/>
    <br><br>

    <input type="submit" value="ok">
</form:form>


</body>
</html>