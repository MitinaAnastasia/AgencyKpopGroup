<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 13.04.2023
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agency</title>
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
    <c:if test="${agency != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${agency == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${agency != null}">
                            Edit Agency
                        </c:if>
                        <c:if test="${agency == null}">
                            Add New Agency
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${agency != null}">
                    <input type="hidden" name="agencyId" value="<c:out value='${agency.agencyId}' />"/>
                </c:if>

                <tr>
                    <th>Agency Name:</th>
                    <td><input type="text"
                               value="<c:out value='${agency.agencyName}' />"
                               class="form-control"
                               name="agencyName" required="required">
                    </td>

                </tr>
                <tr>
                    <th>Director Name</th>
                    <td><input type="text"
                               value="<c:out value='${agency.directorName}' />"
                               class="form-control"
                               name="directorName"></td>

                </tr>

                <tr>
                    <th>Telephone Number</th>
                    <td><input type="text"
                               value="<c:out value='${agency.telephoneNumber}' />"
                               class="form-control"
                               name="telephoneNumber"></td>
                </tr>

                <tr>
                    <th>Address</th>
                    <td><input type="text"
                               value="<c:out value='${agency.address}' />"
                               class="form-control"
                               name="address"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</div>
</div>
</body>
</html>
