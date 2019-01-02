<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<nav class="navbar navbar-dark bg-pantone192c">
	<a class="navbar-brand" href="/sgu/home">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Listagem de Usuário</h1>
</section>
<section class="justify-content-center text-center">
	<table class="table table-sm table-striped table-borderless table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Login</th>
				<th>Perfil</th>
				<th>E-mail</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.perfil}</td>
					<td>${usuario.email}</td>
					<td><a href="/sgu/usuario/alterar/${usuario.id}" class="btn btn-sm btn-info"><i class="fas fa-edit"></i></a></td>
					<td><a href="/sgu/usuario/excluir/${usuario.id}" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<a href="/sgu/usuario/formulario" class="btn btn-success"> Novo Usuário</a>
<a href="/sgu/home" class="btn  btn-danger">Página Inicial</a>