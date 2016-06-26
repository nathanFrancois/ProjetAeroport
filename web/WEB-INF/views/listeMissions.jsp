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
                Mission <small>Liste des missions</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Missions
                    <a href="<c:url value="/mission/ajouter"> </c:url>">
                        <button type="button" class="btn btn-primary btn-sm">
                            <i class="fa fa-pencil" aria-hidden="true"></i>
                            Créer une mission
                        </button>
                    </a>
                </li>
            </ol>
        </div>
        <div>
            <div class="col-lg-12">
                <h2>Liste des missions</h2>
                <div class="table-responsive">
                    <table id="tabProjet" class="table table-hover">
                        <thead>
                        <tr>
                            <th>Libéllé</th>
                            <th>Objectifs associés</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.missions}" var="mapMission">
                            <tr>
                                <td>${mapMission.key.libmission}</td>
                                <td>
                                    <c:forEach items="${mapMission.value}" var="objectif">
                                        ${objectif.libobectif} <br>
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
