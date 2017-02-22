<%@ page import="models.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List students</title>
</head>
<body>
<table border="2">
    <tr>
        <th>Имя студента</th>
        <th>День рождения</th>
        <th>Пол</th>
        <th>Id группы</th>
    </tr>
    <c:forEach items="${listStudents}" var="student">
        <tr>
            <td><c:out value="${student.getName()}"></c:out></td>
            <td><c:out value="${student.getBith_date()}"></c:out></td>
            <td><c:out value="${student.getSex()}"></c:out></td>
            <td><c:out value="${student.getId_group()}"></c:out></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
