<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-dark bg-pantone357c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>

<section class="text-center" id="titulo">
	<h1 class="h1">Cadastro de Comentário</h1>
</section>
<section id="conteudo justify-content-center text-center">
	<form:form action="/sgu/fluxo/salvar/comentario" method="post" modelAttribute="comentario">
	<div class="form-row">
		<div class="form-group col-md-2">
			<label>Código da Classificação</label>
			<form:input cssClass="form-control form-control-sm" path="codigo" />
			<form:errors path="codigo" />
		</div>
		<div class="form-group col-md-1">
			<label>Competência</label>
			<form:input cssClass="form-control form-control-sm" path="competencia" />
			<form:errors path="competencia" />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>Comentário</label>
			<form:textarea cssClass="form-control form-control-sm" rows="5" path="comentario" />
			<form:errors path="comentario" />
		</div>
	</div>

	<form:hidden path="id" />
	<button type="submit" class="btn  btn-success">Salvar</button>
	<a href="/sgu/fluxo/listagem/comentario" class="btn  btn-danger">Cancelar</a>
	<br>
</form:form>
</section>


