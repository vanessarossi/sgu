<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<nav class="navbar navbar-dark bg-dark">
	<a class="navbar-brand" href="home.html">SGU v1.0.0 Unimed São José
		do Rio Pardo </a>
</nav>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<section class="text-center" id="titulo">
		<h1 class="h1">SGU - Sistema de Gestão Unimed</h1>
		<p class="lead">Bem-vindo ${principal.username} !</p>
		<a href="/sgu/logout" class="badge badge-danger">Sair do sistema</a>
	</section>
	<br>

	<section id="menu">
		<div class="row card-columns justify-content-center">
			<div class=" col-11 col-sm-11 col-md-5 col-lg-5 col-xl-5">
				<a href="/sgu/banco">
					<div class="card text-center card-pantone348c" id="banco">
						<i class="fas fa-credit-card fa-5x"></i>
						<div class="card-body">
							<h5 class="card-title">Bancos</h5>
							<p class="card-text">Tenha acesso ao saldo dos bancos
								diariamente.</p>
						</div>
					</div>
				</a>
			</div>
			<div class=" col-11 col-sm-11 col-md-5 col-lg-5 col-xl-5">
				<a href="/sgu/caixa">
					<div class="card text-center card-pantone561c" id="caixa">
						<i class="fas fa-money-bill-alt fa-5x"></i>
						<div class="card-body">
							<h5 class="card-title">Caixas</h5>
							<p class="card-text">Tenha acesso ao saldo dos caixas
								diariamente.</p>
						</div>
					</div>
				</a>
			</div>
		</div>
		<div class="row card-columns justify-content-center">
			<div class=" col-11 col-sm-11 col-md-5 col-lg-5 col-xl-5">
				<a href="/sgu/despesareceita">
					<div class="card card-pantone2627c text-center" id="despesaereceita">
						<i class="fas fa-hand-holding-usd fa-5x"></i>
						<div class="card-body">
							<h5 class="card-title">Despesas e Receitas</h5>
							<p class="card-text">Tenha acesso as despesas e receitas
								diariamente.</p>
						</div>
					</div>
				</a>
			</div>
			<div class=" col-11 csol-sm-5 col-md-5 col-lg-5 col-xl-5">
				<a href="/sgu/fluxo">
					<div class="card card-pantone357c text-center" id="fluxo">
						<i class="fas fa-chart-pie fa-5x"></i>
						<div class="card-body">
							<h5 class="card-title">Fluxo Caixa</h5>
							<p class="card-text">Tenha acesso ao resumo mensal do fluxo de
								caixa.</p>
						</div>
					</div>
				</a>
			</div>
		</div>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="row card-columns justify-content-center">
				<div class=" col-11 col-sm-11 col-md-5 col-lg-5 col-xl-5">
					<a href="/sgu/usuario/listagem">
						<div class="card card-pantone192c text-center" id="usuario">
							<i class="fas fa-users fa-5x"></i>
			
							<div class="card-body">
								<h5 class="card-title">Cadastro de Usuário</h5>
								<p class="card-text">Acesse o seu cadastro de usuários.</p>
							</div>
						</div>
					</a>
				</div>
			</div>
		</sec:authorize>
	</section>
</sec:authorize>
