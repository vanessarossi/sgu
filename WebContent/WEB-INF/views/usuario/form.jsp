<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<nav class="navbar navbar-dark bg-pantone192c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Cadastro de Usuário</h1>
</section>
<form:form action="/sgu/usuario/salvar" method="post" modelAttribute="usuario">
	<div class="form-row">
		<div class="form-group col-md-2">
			<label>Login</label>
			<form:input cssClass="form-control form-control-sm" path="login" />
			<form:errors path="login" />
		</div>
		<div class="form-group col-md-4">
			<label>Nome</label>
			<form:input cssClass="form-control form-control-sm" path="nome" />
			<form:errors path="nome" />
		</div>
		<div class="form-group col-md-2">
			<label>Senha</label>
			<form:password cssClass="form-control form-control-sm" path="senha" />
			<form:errors path="senha" />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label>E-mail</label>
			<form:input cssClass="form-control form-control-sm" path="email" />
			<form:errors path="email" />
		</div>
		<div class="form-group col-md-1">
			<label>Ativo</label>
			<form:checkbox cssClass="form-control form-control-sm" path="ativo" value="1"></form:checkbox>
			<form:errors path="ativo" />
		</div>		
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<label>Perfil</label>
			<form:select path="perfil" cssClass="form-control form-control-sm">
				<form:option value="">SELECIONE</form:option>
				<form:option value="ROLE_ADMIN">ADMINISTRADOR</form:option>
				<form:option value="ROLE_USER">GESTOR</form:option>
			</form:select>
			<form:errors path="perfil" />
		</div>
	</div>
	<form:hidden path="id" />
	<button type="submit" class="btn  btn-success">Salvar</button>
	<a href="/sgu/home" class="btn  btn-danger">Cancelar</a>
	<br>
</form:form>
