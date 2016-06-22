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
                Formations <small>Vue globale formation</small>
            </h1>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-danger">
                    <i class="fa fa-list-alt" aria-hidden="true"></i>
                    <b>Mes jeux en cours </b>
                </div>
            </div>
        </div>

        <div class="row">
            <c:forEach items="${requestScope.inscriptions}" var="inscription" varStatus="counter">
                <c:choose>
                    <c:when test="${counter.index mod 3 == 0 }">
                        <c:set var="color" value="alert-warning" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="color" value="alert-info" />
                    </c:otherwise>
                </c:choose>
                <a href="#">
                    <div class="col-lg-3">
                        <div class="alert ${color} text-center">
                            <i class="fa fa-briefcase fa-2x" aria-hidden="true"></i>&nbsp;<b>${inscription.jeu.libellejeu} </b>
                            <br>Inscrit le : ${inscription.dateInscription}
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>

	</jsp:attribute>

</t:layout>
