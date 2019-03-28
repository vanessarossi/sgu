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
	<div class="row">
		<div class="form-group col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
			<div class="input-group">
				<input type="date" class="form-control" id="data" name="data" required="required">
				<div class="input-group-append">
					<button onclick="calcular()" class="btn btn-info">
						<i class="fas fa-search"> Consultar</i>
					</button>
				</div>
			</div>
		</div>
		<div class="form-group">
			<a href="/sgu/home" class="btn btn-danger">Sair da consulta de despesas e receitas</a>
		</div>
	</div>
	<div class="row form-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center justify-content-center" id="espera">
    	<div>
    		<p class="lead text-center"> Por favor, aguarde o processamento dos dados! </p>
	    	<br/>
	       	<div class="fa-5x">
				<i class="fas fa-spinner fa-spin"></i>
			</div>
    	</div>
    </div>
	<div class="row" id="demonstrativo">
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="despesaNivelUm">
			<p class="text-center"> <strong>${despesa.descricao} :</strong> <strong id="${despesa.codigoNivel}"></strong> </p>
			<table class="table table-hover table-sm">
				<thead>
					<tr>
					   	<th>Descrição</th>
					    <th></th>
					    <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${segundoNivelDespesas}" var="segundoNivelDespesa">
						<tr>
					        <td>${segundoNivelDespesa.descricao}</td>
					        <td id="${segundoNivelDespesa.codigoPrimeiroNivel}${segundoNivelDespesa.codigoNivel}"> </td>
					        <td><a class='btn btn-info btn-sm info-fluxo' onclick="buscarDetalhes(${segundoNivelDespesa.codigoPrimeiroNivel},'${segundoNivelDespesa.codigoNivel}')"><i class='fas fa-info'></i></a></td>
					   </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="receitaNivelUm">
			<p class="text-center"> <strong>${receita.descricao} : </strong><strong id="${receita.codigoNivel}"></strong></p>
			<table class="table table-hover table-sm">
				<thead>
					<tr>
					   	<th>Descrição</th>
					    <th></th>
					    <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${segundoNivelReceitas}" var="segundoNivelReceita">
						<tr>
					        <td>${segundoNivelReceita.descricao}</td>
					        <td id="${segundoNivelReceita.codigoPrimeiroNivel}${segundoNivelReceita.codigoNivel}"> </td>
					        <td><a class='btn btn-info btn-sm info-fluxo' onclick="buscarDetalhes(${segundoNivelReceita.codigoPrimeiroNivel},'${segundoNivelReceita.codigoNivel}')"><i class='fas fa-info'></i></a></td>
					   </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>
<div class="modal fade" id="detalhe" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <table class="table" id="tabelaDetalhe">
			<thead>
				<tr>
					<th>Descrição</th>
				    <th>Valor</th>
				</tr>
			</thead>
			<tbody>  
			</tbody>
		</table>
    </div>
  </div>
</div>
<spring:url value="/resources/js/despesaereceita.js" var="despesaereceitaJs"></spring:url>
<script type="text/javascript" src="${despesaereceitaJs}"></script>