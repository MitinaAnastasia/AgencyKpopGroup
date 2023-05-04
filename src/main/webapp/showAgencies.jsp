<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 13.04.2023
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Агенство</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Agency</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/new">Add New Agency</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/list">List All Agency</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Agencies</h2></caption>
        <tr>
            <td>ID</td>
            <td>Название</td>
            <td>Имя директора</td>
            <td>Телефон</td>
            <td>Адрес</td>
        </tr>
        <jsp:useBean id="listAgencies" scope="request" type="java.util.List"/>
        <c:forEach var="agency" items="${listAgencies}">
            <tr>
                <td><c:out value="${agency.getAgencyId()}"/></td>
                <td><c:out value="${agency.getAgencyName()}"/></td>
                <td><c:out value="${agency.getDirectorName()}"/></td>
                <td><c:out value="${agency.getTelephoneNumber()}"/></td>
                <td><c:out value="${agency.getAddress()}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${agency.getAgencyId()}' />">Edit</a>
                    &nbsp;&nbsp; <a
                        href="${pageContext.request.contextPath}/delete?id=<c:out value='${agency.getAgencyId()}' />">Delete</a>
                    &nbsp;&nbsp; <a
                        href="${pageContext.request.contextPath}/group?id=<c:out value='${agency.getAgencyId()}' />">Groups</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

