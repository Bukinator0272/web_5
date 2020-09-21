<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css/homeStyle.css" type="text/css"/>
    <meta charset="UTF-8">
</head>
<body class="page">
<div class="page__main">
    <form name="input_id" id="input_temp" action="get-emp" method="post">
        <p><input name="id" type="text"></p>
        <p><input value="Search by id" required type="button" onclick="task_2()"></p>
    </form>
    <form name="input_name" action="get-emp" method="post">
        <p><input id="inputName" name="inputName" required type="text"></p>
        <p><input value="Search by name" type="submit"></p>
    </form>
</div>
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
    <form class="get__all" method="post" action="get-emps">
        <p><input value="Get all" type="submit"></p>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/script.js"></script>
</body>
</html>
