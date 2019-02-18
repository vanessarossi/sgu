<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/css/normalize.css" var="normalizeCSS"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<spring:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css" var="fontawesomeCSS"></spring:url>
<spring:url value="/resources/css/main.css" var="mainCSS"></spring:url>
<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
<spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>

<spring:url value="resources/img/logo_unimed.png" var="logoUnimedImg"></spring:url>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="logoUnimedImg" type="image/x-icon"/>
<title>SGU - <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute> </title>

<script type="text/javascript" src="${jqueryJS}"></script>
<link href="${normalizeCSS}" rel="stylesheet">
<link href="${bootstrapCSS}" rel="stylesheet">
<script type="text/javascript" src="${bootstrapJS}"></script>
<link href="${fontawesomeCSS}" rel="stylesheet" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<link href="${mainCSS}" rel="stylesheet">

</head>
<body>
	<div class="container-fluid">
		<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
	</div>
</body>
</html>