<%@page import="com.zxz.pojo.Worker"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/layui.css">
<title>员工列表</title>
</head>
<body>
<script src="js/layui.js"></script>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>id</td>
        <td>name</td>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${wlist}" var="w" varStatus="st">

        <tr>
            <td>${w.user_id}</td>
            <td>${w.user_pass}</td>     
            <td>${w.uname}</td>
            <td>${w.job}</td>   
            <td>${w.comm}</td>
            <td>${w.sal}</td>   
        </tr>
    </c:forEach>
<%--     <%
    List<Worker> lw = (List<Worker>)request.getAttribute("wlist");
        <input type="text" value="<%=lw.get(0).getUser_pass() %>>"/>
    %> --%>

</table>
</body>
</html>