<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 16/05/2020
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<meta charset="UTF-8">
<title>Test JDBC</title>
<link rel="stylesheet" type="text/css" href="resources/css/styleConnexion.css">

</head>
<body>
<h1>Tests JDBC</h1>
<c:forEach items="${ messages }" var="message" varStatus="boucle">
    <p>${ boucle.count }. $ { message }</p>
</c:forEach>

</body>
</html>
