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
                Action <small>Ajouter une action</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    Action / ajouter
                </li>
            </ol>
        </div>


        <div>
            <div class="col-lg-6 customForm">
                <c:set var="action" scope="request" value="/action/ajouter"/>
                <%@include file="/WEB-INF/views/formAction.jsp" %>
            </div>
        </div>

	</jsp:attribute>

</t:layout>
