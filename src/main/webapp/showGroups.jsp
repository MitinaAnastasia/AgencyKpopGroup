<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 20.04.2023
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Группа</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Group</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/group/new">Add New Group</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/group/list">List All Group</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/list">List All Agency</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Groups</h2></caption>
        <tr>
            <td>ID</td>
            <td>Название</td>
            <td>Дата начала контракта</td>
            <td>Дата окончания контракта</td>
            <td>Имя менеджера</td>
            <td>Id агенства</td>
        </tr>
        <jsp:useBean id="listGroups" scope="request" type="java.util.List"/>
        <c:forEach var="group" items="${listGroups}">
            <tr>
                <td><c:out value="${group.getGroupId()}"/></td>
                <td><c:out value="${group.getGroupName()}"/></td>
                <td><c:out value="${group.getDataStartContract()}"/></td>
                <td><c:out value="${group.getDataEndContract()}"/></td>
                <td><c:out value="${group.getManagerName()}"/></td>
                <td><c:out value="${group.getAgencyIdFk()}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/group/edit?id=<c:out value='${group.getGroupId()}' />">Edit</a>
                    &nbsp;&nbsp; <a
                        href="${pageContext.request.contextPath}/group/delete?id=<c:out value='${group.getGroupId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

