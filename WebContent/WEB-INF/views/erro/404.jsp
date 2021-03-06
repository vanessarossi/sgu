<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<spring:url value="/resources/css/normalize.css" var="normalizeCSS"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<spring:url
	value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	var="fontawesomeCSS"></spring:url>
<spring:url value="/resources/css/main.css" var="mainCSS"></spring:url>
<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
<spring:url value="/resources/js/bootstrap.bundle.min.js"
	var="bootstrapJS"></spring:url>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/resources/img/logo_unimed.png"
	type="image/x-icon" />
<title>SGU - Erro 404</title>

<script type="text/javascript" src="${jqueryJS}"></script>
<link href="${normalizeCSS}" rel="stylesheet">
<link href="${bootstrapCSS}" rel="stylesheet">
<script type="text/javascript" src="${bootstrapJS}"></script>
<link href="${fontawesomeCSS}" rel="stylesheet"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="${mainCSS}" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-dark bg-dark"> <a
			class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão
			Unimed</a> </nav>
		<section class="text-center" id="titulo">
			<h1 class="h1">Página não encontrada !</h1>
		</section>
		<br><br>
		<section class="form-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center">
			<a href="${pageContext.request.contextPath}/home" class="rounded "><img src="${pageContext.request.contextPath}/resources/img/compass.png" alt="compass"/></a>		
		</section>
		<br><br>
		<section class="form-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
			<p class="text-center lead">A página procurada não foi encontrada, entre em contato com o suporte do sistema!</p>		
		</section>

	
	</div>
</body>
</html>