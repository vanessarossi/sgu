<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<nav class="navbar navbar-dark bg-pantone561c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão
		Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Saldo dos Caixas</h1>
	<p class="h5">Data do saldo: ${dataEscolhida}</p>
</section>
<section id="conteudo justify-content-center text-center">
	<form action="/sgu/caixa/consultar" method="post">
		<div class="row">
			<div class="form-group col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
				<div class="input-group">
					<input type="date" class="form-control" id="data" name="data" required="required">
					<div class="input-group-append">
						<button type="submit" class="btn btn-info">
							<i class="fas fa-search"> Consultar</i>
						</button>
					</div>
				</div>
			</div>
			<div class="form-group">
				<a href="/sgu/home" class="btn btn-danger">Sair da consulta ao caixa</a>
			</div>
		</div>
	</form>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${postosAtendimento}" var="postoAtendimento"
						end="8">
						<tr>
							<td>${postoAtendimento.codigo}</td>
							<td>${postoAtendimento.nome}</td>
							<td>${postoAtendimento.saldo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${postosAtendimento}" var="postoAtendimento"
						begin="9">
						<tr>
							<td>${postoAtendimento.codigo}</td>
							<td>${postoAtendimento.nome}</td>
							<td>${postoAtendimento.saldo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center">
		<div class="alert alert-info" role="alert">SALDO TOTAL
			${saldoTotal}</div>
	</div>
</section>
<br>