<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/css/login/style.css" rel="stylesheet">
        <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
        <script src="<%=request.getContextPath()%>/ressources/css/login/prefixfree.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ressources/css/plugins/notification/notification.css">
        <script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/ressources/js/plugins/Notification/bootstrap-notify.js"></script>

        <title>Login</title>
        <script>

                function notificationInsertUserCorrect()
                {
                var notify = $.notify('<strong>Sauvegarde</strong> Ne pas fermer la page ...', {
                type: 'success',
                allow_dismiss: false,
                showProgressbar: true
                });
                setTimeout(function() {
                notify.update('message', '<strong>Sauvegarde</strong> du nouvel utilisateur');
                }, 1000);
                setTimeout(function() {
                notify.update('message', '<strong>Sauvegarde</strong> des nouvelles données');
                }, 2000);
                setTimeout(function() {
                notify.update('message', '<strong>Vérification</strong> des erreurs');
                }, 3000);
                setTimeout(function() {
                notify.update('message', '<strong>Le compte a été crée avec succés !</strong>');
                }, 4000);
                }

        </script>
    </head>

    <body>
        <div class="body"></div>
        <div class="grad"></div>

        <c:if test="${notif=='userInsert'}">
            <script type="text/javascript">notificationInsertUserCorrect();</script>
        </c:if>

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

                <button type="submit">Se connecter</button><br /><br />

                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
            </form>

            <a href="<c:url value="/register"> </c:url>">
                <button> Demander un compte </button>
            </a>

        </div>
    </body>

</html>
