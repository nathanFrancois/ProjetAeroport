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
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Formations
                </li>
            </ol>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <h2>Table des Jeux (Test BD)</h2>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>nom</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.jeux}" var="jeu">
                            <tr>
                                <td>${jeu.numjeu}</td>
                                <td>${jeu.libellejeu}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
	</jsp:attribute>

</t:layout>
