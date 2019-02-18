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
	<form action="#" method="post">
		<div class="form-row justify-content-center text-center">
		    <div class="form-group col-6 col-sm-6 col-md-2 col-lg-2 col-xl-2">
		      <label for="dataInicial">Data inicial</label>
		      <input type="date" class="form-control" id="dataInicial" required="required">
		    </div>
		    <div class="form-group col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
		    	<label for="dataFinal">Data Final</label>
				<div class="input-group">
					<input type="date" class="form-control" id="dataFinal" name="dataFinal" required="required">
					<div class="input-group-append">
						<a href="#" class="btn btn-info" onclick="enviarConsulta()">
							<i class="fas fa-search"> Consultar</i>
						</a>
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
				      <th id="totalReceitaAnterior${demonstrativo.segundoNivelFluxo.codigoNivel}"></th>
				      <th id="totalReceita${demonstrativo.segundoNivelFluxo.codigoNivel}"></th>
				      <th id="totalReceitaPrevisto${demonstrativo.segundoNivelFluxo.codigoNivel}"></th>
				    </tr>
				    <c:forEach items="${demonstrativo.receitaTerceiroNivelFluxo}" var="receita">
				    	<tr>
					      <td>${receita.descricao}</td>
					      <td id="receitaAnterior${receita.codigoSegundoNivel}${receita.codigoNivel}"></td>
					      <td id="receita${receita.codigoSegundoNivel}${receita.codigoNivel}"></td>
					      <td id="receitaPrevisto${receita.codigoSegundoNivel}${receita.codigoNivel}"></td>
					    </tr>
				    </c:forEach>
				    <tr>
				      <th>Despesa</th>
				      <th id="totalDespesaAnterior${demonstrativo.segundoNivelFluxo.codigoNivel}" class="despesa"></th>
				      <th id="totalDespesa${demonstrativo.segundoNivelFluxo.codigoNivel}" class="despesa"></th>
				      <th id="totalDespesaPrevisto${demonstrativo.segundoNivelFluxo.codigoNivel}" class="despesa"></th>
				    </tr>				    
				    <c:forEach items="${demonstrativo.despesaTerceiroNivelFluxo}" var="despesa">
				    	<tr>
					      <td>${despesa.descricao}</td>
					      <td id="despesaAnterior${despesa.codigoSegundoNivel}${despesa.codigoNivel}" class="despesa"></td>
					      <td id="despesa${despesa.codigoSegundoNivel}${despesa.codigoNivel}" class="despesa"></td>
					      <td id="despesaPrevisto${despesa.codigoSegundoNivel}${despesa.codigoNivel}" class="despesa"></td>
					    </tr>
				    </c:forEach>
				  </tbody>
				  <tfoot>
				    <tr>
				      <th>Líquido</th>
				      <td id="totalLiquidoAnterior${demonstrativo.segundoNivelFluxo.codigoNivel}"></td>
				      <td id="totalLiquido${demonstrativo.segundoNivelFluxo.codigoNivel}"></td>
				      <td id="totalLiquidoPrevisto${demonstrativo.segundoNivelFluxo.codigoNivel}"></td>
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
				      <td id="movSaldoLiquidoAnterior${conta.codigo}"></td>
				      <td id="movReceita${conta.codigo}"></td>
				      <td id="movDespesa${conta.codigo}"></td>
				      <td></td>
				      <td id="movSaldoBanco${conta.codigo}"></td>
				      <td id="movSaldoCaixa${conta.codigo}"></td>
				      <td id="movSaldoTotal${conta.codigo}"></td>
				    </tr>
				  </tbody>
				  <tfoot>
						<tr>
							<td colspan="2">Transferências Realizadas</td>
							<td id="movTransRealizada${conta.codigo}"></td>
							<td></td>
							<td colspan="2">Transferências Recebidas</td>
							<td id="movTransRecebida${conta.codigo}"></td>
						</tr>
				  </tfoot>
				</table>
			</c:forEach>
		</div>
	</div>
</section>
<div class="modal fade bs-example-modal-sm" id="spinner" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="false">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-body justify-content-center text-center">
                <p class="lead text-center"> Por favor, aguarde o processamento dos dados! </p>
                <div class="fa-5x">
					<i class="fas fa-spinner fa-spin"></i>
				</div>
            </div>
        </div>
    </div>
</div>
<spring:url value="/resources/js/demonstrativofinanceiro.js" var="demonstrativoJs"></spring:url>
<script type="text/javascript" src="${demonstrativoJs}"></script>
