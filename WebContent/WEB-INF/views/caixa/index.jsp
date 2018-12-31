
<nav class="navbar navbar-dark bg-pantone561c">
	<a class="navbar-brand" href="home.html">SGU - Sistema de Gestão
		Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Caixas</h1>
</section>
<section id="conteudo justify-content-center text-center">
	<div class="row">
		<div class="form-group col-6 col-sm-6 col-md-2 col-lg-2 col-xl-2">
			<label for="data">DATA INICIAL</label> <input type="date"
				class="form-control" id="data">
		</div>
		<div class="form-group col-6 col-sm-6 col-md-2 col-lg-2 col-xl-2">
			<label for="data">DATA FINAL</label> <input type="date"
				class="form-control" id="data">
		</div>
		<div class="form-group">
			<br> <a href="/sgu/home" class="btn btn-secondary">Apresentação
				em gráfico</a> <a href="/sgu/home" class="btn btn-danger">Sair
				daconsulta ao caixa</a>
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg6 col-xl-6" id="table">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<th>1</th>
						<td>CAIXA XX</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
					<tr>
						<th>2</th>
						<td>CAIXA YY</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
					<tr>
						<th>3</th>
						<td>CAIXA ZZ</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
					<tr>
						<th>4</th>
						<td>CAIXA VV</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
					<tr>
						<th>5</th>
						<td>CAIXA MM</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
					<tr>
						<th>6</th>
						<td>CAIXA JJ</td>
						<td>R$ xxx.xxx,00</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"
			id="apresentacao">
			<canvas id="chart"></canvas>
		</div>
	</div>
</section>
<br>