<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" uri="/WEB-INF/locale.tld" %>

<!DOCTYPE html>
<html>
<jsp:include page="WEB-INF/fragments/header.jsp"/>
<head>
    <title>BSU. Ilya Torch. </title>
</head>
<style>
    div {
        margin: 15px;
    }
</style>
<body>
<div style="height: 500px">
    <h1><my:Locale value="index.header.university"/></h1>
    <img src="images/cat.jpg" align="left" width="450" height="281"/>
</div>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/db_students" enctype="multipart/form-data">
        <h2><my:Locale value="index.header.students"/></h2>
        <button type="submit"><my:Locale value="index.header.students.show"/></button>
    </form>
</div>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/file_devices" enctype="multipart/form-data">
        <h2><my:Locale value="index.header.devices"/></h2>
        <h4><my:Locale value="index.header.devices.characteristics"/></h4>
        <h6>Name<br/>
            Origin<br/>
            Price<br/>
            Type (COM, USB, LPT).<br/>
            Critical</h6>
        <p>
        <p>
        <label class="radio-inline"><input type="radio" name="parserType" value="dom" checked><my:Locale value="index.header.devices.parser"/></label>
        <div class="form-group">
            <label for="exampleFormControlFile1"><my:Locale value="index.header.devices.file"/></label>
            <input type="file" class="form-control-file" name="file" id="exampleFormControlFile1" required>
        </div>
        <br/>

        <button type="submit" class="btn btn-primary"><my:Locale value="index.header.devices.parse"/></button>
    </form>
</div>
<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>
