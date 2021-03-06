<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>Accident/Create</title>
</head>
<body>
<div class="container">
    <div class="row">
        <a href="<c:url value='/create'/>">Добавить инцидент</a>
    </div>
</div>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Обновить инцедент
            </div>
            <form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
                <div class="form-group">
                    <label>Название</label>
                    <input required type="text" class="form-control" name="name" value="${accident.name}">
                    <label>Описание</label>
                    <input required type="text" class="form-control" name="text" value="${accident.text}">
                    <label>Адрес</label>
                    <input required type="text" class="form-control" name="address" value="${accident.address}">
                    <div class="form-group">
                        <label>Тип:</label>
                        <select class="form-control" name="type.id">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.id}"><c:out value="${type.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Статьи:</label>
                        <select class="form-control" name="rIds" multiple required>
                            <c:forEach items="${rules}" var="rule">
                                <option value="${rule.id}"><c:out value="${rule.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Обновить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
