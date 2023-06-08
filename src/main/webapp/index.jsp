<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <h1>Ресурсы университета</h1>
    <img src="images/cat.jpg" align="left" width="450" height="281"/>
</div>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/db_students" enctype="multipart/form-data">
        <h2>Показать студентов, хранящихся в базе данных:</h2>
        <button type="submit">Показать</button>
    </form>
</div>
<div>
    <form method="POST" action="${pageContext.request.contextPath}/file_devices" enctype="multipart/form-data">
        <h2>Загрузить информацию об устройствах из файла</h2>
        <h4>Компьютерные комплектующие имеют следующие характеристики:</h4>
        <h6>Name - название комплектующего.<br/>
            Origin - страна производства.<br/>
            Price - цена (0-n рублей).<br/>
            Type (должно быть несколько) - перифирийное либо нет, энергопотребление (ватт), наличие кулера (есть либо нет),
            группа комплектующих (устройства ввода-вывода, мультимедийные), порты (COM, USB, LPT).<br/>
            Critical - критично ли наличие комплектующего для работы компьютера.</h6>
        <p>
        <p>
        <label class="radio-inline"><input type="radio" name="parserType" value="dom" checked>DOM-parser</label>
        <div class="form-group">
            <label for="exampleFormControlFile1">Choose file</label>
            <input type="file" class="form-control-file" name="file" id="exampleFormControlFile1" required>
        </div>
        <br/>

        <button type="submit" class="btn btn-primary">Parse</button>
    </form>
</div>
<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>
