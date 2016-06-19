<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/ressources/css/login/style.css" rel="stylesheet">

    <title>Inscription</title>
</head>

<body>
<div class="body"></div>
<div class="grad"></div>

<div class="col-lg-5 register">
    <h1 class="registerTitle">Inscription</h1>

    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/register">

        <div class="form-group">
            <input
                    type="text"
                    class="form-control"
                    placeholder="Nom"
                    id="nom"
                    name="nom"
                    value="<c:out value=""/>"
            >
            <span>${form.erreurs['nom']}</span>
        </div>

        <div class="form-group">
            <input
                    type="text"
                    class="form-control"
                    placeholder="Prenom"
                    id="prenom"
                    name="prenom"
                    value="<c:out value=""/>"
            >
            <span>${form.erreurs['prenom']}</span>
        </div>

        <div class="form-group">
            <input
                    type="text"
                    class="form-control"
                    placeholder="Username"
                    id="username"
                    name="username"
                    value="<c:out value=""/>"
            >
            <span>${form.erreurs['username']}</span>
        </div>


        <div class="form-group">
            <input
                    type="password"
                    class="form-control"
                    placeholder="Password"
                    id="password"
                    name="password"
                    value="<c:out value=""/>"
            >
            <span>${form.erreurs['password']}</span>
        </div>

        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

        <div class="form-group">
            <div class="col-sm-5">
                <button type="submit" class="btn btn-success">S'inscire !</button>
            </div>
        </div>
        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

    </form>
</div>
</body>
</html>
