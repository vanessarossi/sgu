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
	<h1 class="h1">Saldo das contas Bancárias</h1>
	<p class="h5">Data do saldo: ${dataEscolhida}</p>
</section>
<section id="conteudo justify-content-center text-center">
	<form action="/sgu/banco/consultar" method="post">
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
				<a href="/sgu/home" class="btn btn-danger">Sair da consulta a conta bancaria</a>
			</div>
		</div>
	</form>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg6 col-xl-6">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${bancos}" var="banco" end="10" >
						<tr>
							<td>${banco.codigoConta}</td>
							<td>${banco.nomeConta}</td>
							<td><c:if test="${banco.aplicacao eq 'S'}">APL</c:if></td>
							<td>${banco.valor}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg6 col-xl-6">
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${bancos}" var="banco" begin="11" >
						<tr>
							<td>${banco.codigoConta}</td>
							<td>${banco.nomeConta}</td>
							<td><c:if test="${banco.aplicacao eq 'S'}">APL</c:if></td>
							<td>${banco.valor}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br/>
	 
	<table class="table table-sm table-success text-center" id="resumo_valor">
	  <thead>
	    <tr>
	      <th>SALDO TOTAL CONTA CORRENTE</th>
	      <th>SALDO TOTAL CONTA APLICAÇÃO</th>
	      <th>SALDO TOTAL CONTA APLICAÇÃO ANS</th>
	      <th >SALDO TOTAL CONTAS</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td>${saldoTotalContaCorrente}</td>
	      <td>${saldoTotalAplicacao}</td>
	      <td>${saldoTotalAplicacaoAns}</td>
	      <td>${saldoTotal}</td>
	    </tr>
	  </tbody>
	</table>
</section>
<br>