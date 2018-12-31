<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<nav class="navbar navbar-dark bg-pantone">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Bancos</h1>
</section>
<section id="conteudo justify-content-center text-center">
	<div class="row">
		<div class="form-group col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
			<label for="data">DATA</label> <input type="date" class="form-control" id="data">
		</div>
		<div class="form-group">
			<br> <a href="/sgu/home" class="btn btn-danger">Sair da consulta ao banco</a>
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg6 col-xl-6" id="table">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${bancos}" var="banco" varStatus="i" >
						<tr>
							<td>${banco.codigoConta}</td>
							<td>${banco.nomeConta}</td>
							<td>${banco.contaAplicacao}</td>
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