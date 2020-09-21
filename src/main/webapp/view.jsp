<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="css/homeStyle.css" type="text/css"/>
    <meta charset="UTF-8">
</head>
<body class="page">
<div class="temp">
    <table class="table">
        <caption>Employees</caption>
        <tr>
            <th>Номер сотрудника</th>
            <th>Имя сотрудника</th>
            <th>Должность сотрудника</th>
            <th>Mgr сотрудника</th>
            <th>Дата принятия на работу</th>
            <th>Sal сотрудника</th>
            <th>Comm сотрудника</th>
            <th>Номер департамента</th>
            <th>Название департамента</th>
            <th>Местоположение департамента</th>
        </tr>
        <c:forEach var="emp" items="${emps}">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td>${emp.hireDate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.dept.deptno}</td>
                <td>${emp.dept.dname}</td>
                <td>${emp.dept.loc}</td>
            </tr>
        </c:forEach>
    </table>
    <h2><a href="home.jsp">Get back to home.</a></h2>
</div>
</body>
</html>
