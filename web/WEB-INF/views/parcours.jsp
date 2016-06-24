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
                Parcours <small>Mon parcours de formation</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Parcours
                </li>
            </ol>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <!--Timeline -->
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <i class="fa fa-clock-o fa-fw"></i>Mes actions réalisées
                    </div>

                    <div class="panel-body">
                        <ul class="timeline">

                            <c:forEach items="${requestScope.obtients}" var="hashObtient" varStatus="counter">
                                <c:choose>
                                    <c:when test="${counter.index mod 2 == 0 }">
                                        <c:set var="place" value="" />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="place" value="timeline-inverted" />
                                    </c:otherwise>
                                </c:choose>
                                <li class="${place}">
                                    <div class="timeline-badge">

                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">${hashObtient.value.libaction}</h4>
                                            <p>
                                                <small class="text-muted"><i class="fa fa-time"></i>Mission</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Obtenu le : ${hashObtient.key.datejour}</p>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        <div>

	</jsp:attribute>

</t:layout>








