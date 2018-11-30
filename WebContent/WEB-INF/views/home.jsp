<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="text-center">
	<h1 class="display-3">UniResultado</h1>
	<p class="lead">Sistema para integra��o do resultado/laudo com o prontu�rio eletr�nico Unimed</p>
	<p class="lead">Bem vindo, nomePessoa !</p>
</section>
<section>
	<a href="/uniresultado/prestador/listagem">Cadastro de Prestador</a>
	<a href="/uniresultado/usuario/listagem">Cadastro de Usu�rio</a>
	<a href="/uniresultado/resultado/formulario">Cadastro de Resultado/Laudo</a>
	<a href="/uniresultado/resultado/conferencia">Confer�ncia do Resultado/Laudo</a>
	<a href="/uniresultado/resultado/envio">Envio de Resultado/Laudo para o prontu�rio</a>
	<a href="/uniresultado/logEnvio/listagem">Log de Envio</a>
</section>