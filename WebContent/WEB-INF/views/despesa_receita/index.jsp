<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="nasvbar navbar-dark bg-pantone2627c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Despesas e Receitas</h1>
	<p class="h5">Data do saldo:</p><label class="h5" id="dataSaldo">${dataEscolhida}</label>
</section>
<section id="conteudo justify-content-center text-center">
	<form action="/sgu/despesareceita/consultar" method="post">
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
				<a href="/sgu/home" class="btn btn-danger">Sair da consulta de despesas e receitas</a>
			</div>
		</div>
	</form>
	<div class="row" id="demonstrativo">
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="despesaNivelUm">
			<p><strong>${despesa.codigo}</strong> - ${despesa.descricao} : <strong>${saldoTotalDespesaNivel1}</strong></p>
			<table class="table table-hover table-sm">
				<thead>
					<tr>
						<th>Código</th>
					   	<th>Descrição</th>
					    <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${segundoNivelDespesas}" var="segundoNivelDespesa">
						<tr>
					    	<td id="${segundoNivelDespesa.codigoNivel}"><button onclick="">EXPANDIR</button>${segundoNivelDespesa.codigo}</td>
					        <td id="segundoNivelDespesa${segundoNivelDespesa.codigoNivel}">${segundoNivelDespesa.descricao}</td>
					        <td>R$ ${segundoNivelDespesa.valorTotal}</td>
					   </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="receitaNivelUm"></div>
	</div>
</section>
<br>
<spring:url value="/resources/js/despesaereceita.js" var="despesaereceitaJs"></spring:url>
<script type="text/javascript" src="${despesaereceitaJs}"></script>