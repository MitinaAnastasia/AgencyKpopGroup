<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 20.04.2023
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Group</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/group/new">Add New Group</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/group/list">List All Group</a>
    </h2>
</div>
<div align="center">
    <c:if test="${group != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${group == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${group != null}">
                            Edit Group
                        </c:if>
                        <c:if test="${group == null}">
                            Add New Group
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${group != null}">
                    <input type="hidden" name="groupId" value="<c:out value='${group.groupId}' />"/>
                </c:if>

                <tr>
                    <th>Group Name:</th>
                    <td><input type="text"
                               value="<c:out value='${group.groupName}' />"
                               class="form-control"
                               name="groupName" required="required">
                    </td>

                </tr>
                <tr>
                    <th>Data Start Contract:</th>
                    <td><input type="date"
                               value="<c:out value='${group.dataStartContract}' />"
                               class="form-control"
                               name="dataStartContract"></td>

                </tr>

                <tr>
                    <th>Data End Contract</th>
                    <td><input type="date"
                               value="<c:out value='${group.dataEndContract}' />"
                               class="form-control"
                               name="dataEndContract"></td>
                </tr>

                <tr>
                    <th>Manager Name</th>
                    <td><input type="text"
                               value="<c:out value='${group.managerName}' />"
                               class="form-control"
                               name="managerName"></td>
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
