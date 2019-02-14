<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-dark bg-pantone357c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>

<section class="text-center" id="titulo">
	<h1 class="h1">Demonstrativo Financeiro</h1>
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
	<div class="row justify-content-center text-center">
		<div class="col-12 col-sm-12 col-md-11 col-lg-11 col-xl-11">
			<c:forEach items="${demonstrativos}" var="demonstrativo">
				<p class="h5 bg-success text-white">${demonstrativo.segundoNivelFluxo.descricao}</p>
				<table class="table table-striped table-hover table-sm">
				  <thead>
				    <tr>
				      <th> </th>
				      <th>Saldo Anterior</th>
				      <th>Saldo Atual</th>
				      <th>Saldo Previsto</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th>Receita</th>
				      <th>R$ 00</th>
				      <th>R$ 00</th>
				      <th>R$ 00</th>
				    </tr>
				    <c:forEach items="${demonstrativo.receitaTerceiroNivelFluxo}" var="receita">
				    	<tr>
					      <td>${receita.descricao}</td>
					      <td>R$ 00</td>
					      <td>R$ 00</td>
					      <td>R$ 00</td>
					    </tr>
				    </c:forEach>
				    <tr>
				      <th>Despesa</th>
				      <th>R$ 00</th>
				      <th>R$ 00</th>
				      <th>R$ 00</th>
				    </tr>				    
				    <c:forEach items="${demonstrativo.despesaTerceiroNivelFluxo}" var="despesa">
				    	<tr>
					      <td>${despesa.descricao}</td>
					      <td>R$ 00</td>
					      <td>R$ 00</td>
					      <td>R$ 00</td>
					    </tr>
				    </c:forEach>
				  </tbody>
				  <tfoot>
				    <tr>
				      <th>Líquido</th>
				      <td>R$ 9999</td>
				      <td>R$ 9999</td>
				      <td>R$ 9999</td>
				    </tr>
				  </tfoot>
				</table>
			</c:forEach>
		</div>
	</div>
	<div class="row justify-content-center text-center">
		<div class="col-11 col-sm-11 col-md-11 col-lg-11 col-xl-11">
			<div class="text-center" id="titulo">
				<h3 class="h3">Movimentação</h3>
			</div>
			<c:forEach items="${contas}" var="conta">
				<p class="h5 bg-danger text-white">${conta.descricao}</p>
				<table class="table table-striped table-hover table-sm">
				  <thead>
				    <tr>
				      <th>Saldo Líquido Anterior</th>
				      <th>Receita</th>
				      <th>Despesa</th>
				      <th></th>
				      <th>Saldo Banco</th>
				      <th>Saldo Caixa</th>
				      <th>Total</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<tr>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				  </tbody>
				  <tfoot>
						<tr>
							<td colspan="2">Transferências Realizadas</td>
							<td></td>
							<td></td>
							<td colspan="2">Transferências Recebidas</td>
							<td></td>
						</tr>
				  </tfoot>
				</table>
			</c:forEach>
		</div>
	</div>
</section>
