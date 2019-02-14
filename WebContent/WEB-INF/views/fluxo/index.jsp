<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-dark bg-pantone357c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>

<section class="text-center" id="titulo">
	<h1 class="h1">Fluxo de Caixa</h1>
</section>
<section id="conteudo justify-content-center text-center">
	<form>
		<div class="form-row">
		    <div class="form-group col-6 col-sm-6 col-md-2 col-lg-2 col-xl-2">
		      <label for="dataInicial">Data inicial</label>
		      <input type="date" class="form-control" id="dataInicial" requi>
		    </div>
		    <div class="form-group col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
		    		<label for="dataFinal">Data Final</label>
					<div class="input-group">
						<input type="date" class="form-control" id="dataFinal" name="dataFinal" required="required">
						<div class="input-group-append">
							<button type="submit" class="btn btn-info">
								<i class="fas fa-search"> Consultar</i>
							</button>
						</div>
					</div>
			</div>
		 </div>
	</form>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-102">
			<c:forEach items="${centrosCusto}" var="centroCusto">
				<p class="h5 bg-success text-white">${centroCusto.descricao}</p>
				<table class="table table-striped table-hover table-sm">
				  <thead>
				    <tr>
				      <th>Competência</th>
				      <th>Receita</th>
				      <th>Despesa</th>
				      <th>Líquido</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				  </tbody>
				</table>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-10">
			<c:forEach items="${principaisContas}" var="contaPrincipal">
				<p class="h5 bg-success text-white">${contaPrincipal.contaFluxo.descricao}</p>
				<table class="table table-striped table-hover table-sm">
				  <thead>
				    <tr>
				      <th>Competência</th>
				      <th>Banco</th>
				      <th>Caixa</th>
				      <th>Total</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>${contaPrincipal.competencia}</td>
				      <td>${contaPrincipal.valorBanco}</td>
				      <td>${contaPrincipal.valorCaixa}</td>
				      <td>${contaPrincipal.valorTotal}</td>
				    </tr>
				  </tbody>
				  <tfoot>
						<tr>
							<td>Transferências Realizadas</td>
							<td></td>
							<td>Transferências Recebidas</td>
							<td></td>
						</tr>
				  </tfoot>
				</table>
			</c:forEach>
		</div>
	</div>
</section>
