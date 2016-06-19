<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/css/login/style.css" rel="stylesheet">
        <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
        <script src="<%=request.getContextPath()%>/ressources/css/login/prefixfree.min.js"></script>


        <title>Login</title>
    </head>

    <body>
        <div class="body"></div>
        <div class="grad"></div>

        <div class="login">
            <form class="form-inline" role="form" name="f" action="<c:url value="/login"/>" method="post">
                <div class="form-group">
                    <label for="username">Username</label><br />
                    <input type="text" class="form-control" id="username" name="username"/>
                </div>

                <div class="form-group">
                    <label for="password">Password</label><br />
                    <input type="password" class="form-control" id="password" name="password"/>
                </div>

                <button type="submit">Log in</button><br /><br />

                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
            </form>

            <a href="<c:url value="/register"> </c:url>">
                <button> Demander un compte </button>
            </a>

        </div>
    </body>
</html>
