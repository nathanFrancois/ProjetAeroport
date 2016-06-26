<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
        Objectifs
	</jsp:attribute>

	<jsp:attribute name="body">
        <div class="col-lg-12">
            <h1 class="page-header">
                Jeu <small>Liste des jeux</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Jeux
                    <a href="<c:url value="/jeu/ajouter"> </c:url>">
                        <button type="button" class="btn btn-primary btn-sm">
                            <i class="fa fa-pencil" aria-hidden="true"></i>
                            Créer une jeu
                        </button>
                    </a>
                </li>
            </ol>
        </div>
        <div>
            <div class="col-lg-12">
                <h2>Liste des jeux</h2>
                <div class="table-responsive">
                    <table id="tabProjet" class="table table-hover">
                        <thead>
                        <tr>
                            <th>Libéllé</th>
                            <th>missions associées</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.jeux}" var="mapJeu">
                            <tr>
                                <td>${mapJeu.key.libellejeu}</td>
                                <td>
                                    <c:forEach items="${mapJeu.value}" var="mission">
                                        ${mission.libmission} <br>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
	</jsp:attribute>

</t:layout>
