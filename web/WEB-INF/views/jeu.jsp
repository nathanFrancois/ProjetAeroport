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
                Jeu <small> Détails du jeu : ${requestScope.jeu.libellejeu} </small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Accueil / Formation / Jeu
                </li>
            </ol>
        </div>

        <div class="row">
            <c:forEach items="${requestScope.missions}" var="mapMission" varStatus="counter">

                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            ${ mapMission.key.libmission}
                        </div>
                        <div class="panel-body">
                            <c:forEach items="${mapMission.value}" var="objectif" varStatus="counter">
                                <a data-toggle="modal" data-target=".bs-${objectif.numobjectif}-${mapMission.key.nummission}">
                                    ${ objectif.libobectif} <br>
                                </a>
                                <div class="modal fade bs-${objectif.numobjectif}-${mapMission.key.nummission}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <c:forEach items="${actions}" var="mapAction" varStatus="counter">

                                                <c:if test="${objectif.numobjectif == mapAction.key.numobjectif}">

                                                    <c:forEach items="${mapAction.value}" var="action" varStatus="counter">
                                                        ${action.libaction} <br>
                                                    </c:forEach>

                                                </c:if>

                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="panel-footer">

                        </div>

                    </div>
                </div>

            </c:forEach>
        </div>


	</jsp:attribute>

</t:layout>

