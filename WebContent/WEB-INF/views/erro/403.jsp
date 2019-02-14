<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-fluid">
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão
			Unimed</a>
	</nav>
	<section class="text-center" id="titulo">
		<h1 class="h1">Acesso negado !</h1>
	</section>
	<br>
	<br>
	<section
		class="form-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center">
		<a href="${pageContext.request.contextPath}/home" class="rounded "><img
			src="${pageContext.request.contextPath}/resources/img/shielddenied.png"
			alt="shield" /></a>
	</section>
	<br>
	<br>
	<section
		class="form-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
		<p class="text-center lead">Ops! Você não tem as permissões
			necessárias para executar a ação!</p>
	</section>


</div>
