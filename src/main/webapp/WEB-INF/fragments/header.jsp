<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="/WEB-INF/locale.tld" %>

<head>
    <title>Lab8</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index"><my:Locale value="header.home"/></a>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/language?language=fr">FR</a>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/language?language=en">EN</a>
        </div>
    </div>
</nav>
