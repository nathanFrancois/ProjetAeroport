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
                Accueil <small>Bienvenue</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Accueil
                </li>
            </ol>
        </div>
        <div>
            <span>Bonjour les régaleurs, on pisse du code ?</span>
        </div>
	</jsp:attribute>

</t:layout>
