<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="headTitle" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/css/layout.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/css/sb-admin.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/css/plugins/morris.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/ressources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/plugins/morris/raphael.min.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/plugins/morris/morris.min.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/plugins/morris/morris-data.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/bootstrap.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/ressources/js/jquery.js"></script>

        <title>
            <jsp:invoke fragment="headTitle"/>
        </title>
    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/"> </c:url>">Aeroport du turfu</a>
                </div>

                <!-- Menu haut -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name} <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-user"></i> Profil</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Messagerie</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Pramètres</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="<c:url value="/logout">/></c:url>"><i class="fa fa-fw fa-power-off"></i> Déconnexion</a>
                            </li>
                        </ul>
                    </li>
                </ul>

                <!-- Menu coté -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="<c:url value="/formations"> </c:url>"><i class="fa fa-fw fa-dashboard"></i> Formations</a>
                        </li>
                        <li class="">
                            <a href="<c:url value="/parcours"> </c:url>"><i class="fa fa-fw fa-bar-chart-o"></i> Parcours</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div id="page-wrapper">
                <jsp:invoke fragment="body"/>
            </div>
        </div>
    </body>
</html>