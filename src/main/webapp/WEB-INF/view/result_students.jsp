<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="../fragments/header.jsp"/>
<body>
<c:if test="${requestScope.status}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Average Mark</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tbody>
            <tr>
                <td><c:out value="${user.getUserId()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getFirstName()}"/></td>
                <td><c:out value="${user.getLastName()}"/></td>
                <td><c:out value="${user.getAvgMark()}"/></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</c:if>
<c:if test="${!requestScope.status}">
    <h1 align="center" style="color:red">ERROR</h1>
    <hr align="center" width="70%">
    <h4 align="center">This file is not valid!</h4>
    <h4 align="center">Press Home to return</h4>
</c:if>
<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
