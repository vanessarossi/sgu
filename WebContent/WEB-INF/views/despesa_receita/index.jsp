<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<nav class="nasvbar navbar-dark bg-pantone2627c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Despesas e Receitas</h1>
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
			<p><strong>${despesa.codigo}</strong> - ${despesa.descricao} : </p>
			<table class="table table-hover table-sm">
			    <thead>
			        <th>Código Fluxo</th>
			        <th>Descrição</th>
			        <th></th>
			    </thead>
			    <tbody>
			    	<c:forEach items="${segundoNivelDespesas}" var="segundoNivelDespesa">
				        <tr data-toggle="collapse" data-target='#segundoNivelDespesa${segundoNivelDespesa.codigoAcesso}' class="clickable">
				            <td>${segundoNivelDespesa.codigo}</td>
				            <td>${segundoNivelDespesa.descricao}</td>
				            <td>R$</td>
				        </tr>
				        <tr>
				            <td colspan="3">
				                <div id="segundoNivelDespesa${segundoNivelDespesa.codigoAcesso}" class="collapse">
				                	<a href="#" onclick="expandirTerceiroNivel('${segundoNivelDespesa.codigoPrimeiroNivel}','${segundoNivelDespesa.codigoNivel}')"> TESTE SEGUNDO NIVEL</a>
				                </div>
				            </td>
				        </tr>
				     </c:forEach>
			    </tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="receitaNivelUm">
			<p><strong>${receita.codigo}</strong> - ${receita.descricao} : </p>
			<table class="table table-hover table-sm">
			    <thead>
			        <th>Código Fluxo</th>
			        <th>Descrição</th>
			        <th></th>
			    </thead>
			    <tbody>
			    	<c:forEach items="${segundoNivelReceitas}" var="segundoNivelReceita">
				        <tr data-toggle="collapse" data-target='#segundoNivelReceita${segundoNivelReceita.codigoAcesso}' class="clickable">
				            <td>${segundoNivelReceita.codigo}</td>
				            <td>${segundoNivelReceita.descricao}</td>
				            <td>R$</td>
				        </tr>
				        <tr>
				            <td colspan="3">
				                <div id="segundoNivelReceita${segundoNivelReceita.codigoAcesso}" class="collapse">
				                	<a href="/sgu/despesareceita/pesquisaTerceiroNivel/${segundoNivelReceita.codigoPrimeiroNivel}/${segundoNivelReceita.codigoNivel}"> TESTE SEGUNDO NIVEL</a>
				                </div>
				            </td>
				        </tr>
				     </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</section>
<br>

<script type="text/javascript">

 
function expandirTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel){
	console.log("primeiro "+codigoPrimeiroNivel);
	console.log("Segundo "+codigoSegundoNivel);

	$.ajax({
			 url : '/sgu/despesareceita/pesquisaTerceiroNivel/'+codigoPrimeiroNivel+'/'+codigoSegundoNivel,
		     type : 'get',
		beforeSend : function(){
		     	
		}
		})
		.done(function(msg){
		         
		 })
		.fail(function(jqXHR, textStatus, msg){
		          alert(msg);
	}); 
}
 
</script>