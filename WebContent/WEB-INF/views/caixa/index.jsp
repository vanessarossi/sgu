<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<nav class="navbar navbar-dark bg-pantone561c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão
		Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Caixas</h1>
</section>
<section id="conteudo justify-content-center text-center">
	<div class="row">
		<div class="form-group">
			<a href="/sgu/home" class="btn btn-danger">Sair da consulta ao
				caixa</a>
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg6 col-xl-6" id="table">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${postosAtendimento}" var="postoAtendimento">
						<tr>
							<td>${postoAtendimento.codigo}</td>
							<td>${postoAtendimento.nome}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"
			id="apresentacao">
			<canvas id="chart"></canvas>
		</div>
	</div>
</section>
<br>