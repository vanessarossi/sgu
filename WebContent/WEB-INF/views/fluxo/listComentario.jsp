<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<spring:url value="/resources/css/datatables.css" var="dataTableCSS"></spring:url>
<link href="${dataTableCSS}" rel="stylesheet">

<nav class="navbar navbar-dark bg-pantone357c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>

<section class="text-center" id="titulo">
	<h1 class="h1">Lista de Comentários</h1>
</section>

<div class="form-group">
	<a href="/sgu/home" class="btn btn-danger">Sair da listagem de comentários</a>
	<a href="/sgu/fluxo/formulario/comentario" class="btn btn-secondary">Novo Comentário</a>
</div>

<section id="conteudo">
	<table class="table table-striped table-hover" id="tabelaComentario">
		<thead>
			<tr>
				<th>Código</th>
				<th>Competência</th>
				<th>Comentário</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comentarios}" var="comentario">
				<tr>
					<td>${comentario.codigo}</td>
					<td>${comentario.competencia}</td>
					<td>${comentario.comentario}</td>
					<td>
						<a href="/sgu/fluxo/editar/comentario/${comentario.id}" class="btn btn-sm btn-warning"><i class="fas fa-edit"></i></a>
						<a href="/sgu/fluxo/excluir/comentario/${comentario.id}" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<spring:url value="/resources/js/datatables.min.js" var="dataTableJs"></spring:url>
<spring:url value="/resources/js/listaComentario.js" var="listaComentario"></spring:url>
<script type="text/javascript" src="${dataTableJs}"></script>
<script type="text/javascript" src="${listaComentario}"></script>


