<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 28.08.2020
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>report_page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <table>
        <c:forEach items="${sessionScope.report}" var="operation">
            <tr>
                <td><div>operation_id = ${operation.operationId}</div></td>
                <td><div>num_1 = ${operation.num1}</div></td>
                <td><div>num_2 = ${operation.num2}</div></td>
                <td><div>operation_type = ${operation.type}</div></td>
                <td><div>result = ${operation.result}</div></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Home</a>
</body>
</html>
