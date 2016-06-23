<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
        Dashboard
	</jsp:attribute>

	<jsp:attribute name="body">
        <div class="col-lg-12">
            <h1 class="page-header">
                Profil <small>Vue gloable</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Profil / Consultation
                </li>
            </ol>
            <div>
                <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/profil">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="username">Login</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" name="username" value="${user.username}" disabled="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="prenom">Prénom</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="${user.prenomusers}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="nom">Nom</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${user.nomusers}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="password">Mot de passe</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password" value="${user.password}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Mettre à jour</button>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
	</jsp:attribute>

</t:layout>
