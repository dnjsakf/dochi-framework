<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Board
  <ul>
  <c:forEach var="item" items="${datas }">
    <li>${item.fullName }</li>
  </c:forEach>
  </ul>
</body>
</html>