<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <meta charset="UTF-8">
</head>
<body class="body">
<div class="main">
    <form class="form" action="calculator" method="post">
        <label for="firstNum">First number</label>
        <input type="number" id="firstNum" name="firstNum" title="Enter number" required value="${firstNum}">

        <label for="secondNum">Second number</label>
        <input type="number" id="secondNum" name="secondNum" title="Enter number" required value="${secondNum}">

        <div class="buttons">
            <input class="submit_btn" type="submit" name="sign" value="+">
            <input class="submit_btn" type="submit" name="sign" value="-">
            <input class="submit_btn" type="submit" name="sign" value="*">
            <input class="submit_btn" type="submit" name="sign" value="/">
        </div>
    </form>
    <p class="answer">${answer}</p>
</div>
</body>
</html>
