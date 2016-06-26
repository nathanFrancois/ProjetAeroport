<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
        Actions
	</jsp:attribute>

	<jsp:attribute name="body">
        <div class="col-lg-12">
            <h1 class="page-header">
                Actions <small>Liste des actions</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Actions
                    <a href="<c:url value="/action/ajouter"> </c:url>">
                        <button type="button" class="btn btn-primary btn-sm">
                            <i class="fa fa-pencil" aria-hidden="true"></i>
                            Créer une action
                        </button>
                    </a>
                </li>
            </ol>
        </div>
        <div>
            <div class="col-lg-12">
                <h2>Liste des Actions</h2>
                <div class="table-responsive">
                    <table id="tabProjet" class="table table-hover">
                        <thead>
                        <tr>
                            <th>Libéllé</th>
                            <th>Score minimum</th>
                            <th>Action précédente</th>
                            <th>Numéro Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.actions}" var="action">
                            <tr>
                                <td>${action.libaction}</td>
                                <td>${action.scoremin}</td>
                                <td>
                                <c:if test="${!(action.action == null)}">
                                    ${action.action.libaction}
                                </c:if>
                                </td>
                                <td>${action.numaction}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
	</jsp:attribute>

</t:layout>
