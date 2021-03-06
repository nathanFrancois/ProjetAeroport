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
                Apprenants <small>Liste des apprenants</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-user"></i> Apprenants
                </li>
            </ol>
        </div>
        <div>
            <div class="col-lg-12">
                <h2>Liste des apprenants</h2>
                <div class="table-responsive">
                    <table id="tabProjet" class="table table-hover">
                        <thead>
                            <tr>
                                <th>Prenom</th>
                                <th>Nom</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.apprenants}" var="apprenant">
                            <tr>
                                <td>${apprenant.prenomusers}</td>
                                <td>${apprenant.nomusers}</td>
                                <td>${apprenant.username}</td>
                                <td>
                                <c:if test="${!apprenant.enabled}">
                                    <a href="<c:url value="/apprenants/valider/${apprenant.idusers}">/></c:url>">
                                        <i class="fa fa-check" aria-hidden="true"></i>
                                    </a>
                                </c:if>
                                    <a href="<c:url value="/apprenants/supprimer/${apprenant.idusers}">/></c:url>">
                                        <i class="fa fa-times" aria-hidden="true"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <table id="test" class="table table-hover">
            <thead>
            <tr>
                <th>Prenom</th>
                <th>Nom</th>
                <th>Username</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.apprenants}" var="apprenant">
                <tr>
                    <td>${apprenant.prenomusers}</td>
                    <td>${apprenant.nomusers}</td>
                    <td>${apprenant.username}</td>
                    <td>
                        <c:if test="${!apprenant.enabled}">
                            <a href="<c:url value="/apprenants/valider/${apprenant.idusers}">/></c:url>">
                                <i class="fa fa-check" aria-hidden="true"></i>
                            </a>
                        </c:if>
                        <a href="<c:url value="/apprenants/supprimer/${apprenant.idusers}">/></c:url>">
                            <i class="fa fa-times" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
	</jsp:attribute>

</t:layout>
