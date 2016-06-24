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
                Formation <small>Inscription à un jeu</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Accueil / Formation / Inscription
                </li>
            </ol>
        </div>


        <div>
            <div class="col-lg-6 customForm">
                <form role="form" method="post" action="<c:url value="/formations/inscription"/>">
                    <div class="form-group">
                        <label>Jeux</label>
                        <select class="form-control" name="listeJeux" id="listeJeux">
                            <c:forEach items="${ sessionScope.jeux }" var="mapJeux">
                                <option value="${ mapJeux.value.numjeu }">${ mapJeux.value.libellejeu}</option>
                            </c:forEach>
                        </select>
                        <span>${form.erreurs['listeJeux']}</span>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

                    <button type="submit" class="btn btn-default">S'inscire</button>

                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                </form>
            </div>
        </div>



	</jsp:attribute>

</t:layout>
