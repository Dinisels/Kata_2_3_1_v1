<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>
    Add new user form
</h2>
<br>

<form:form action="saveUser" modelAttribute="user">

    Name <form: input path = "name"/>
    <br><br>
    Age <form: input path = "age"/>
    <br><br>
    Email <form: input path = "email"/>
    <br><br>

    <input type="submit" value="ok">
</form:form>


</body>
</html>