<nav class="navbar navbar-dark bg-pantone2627c">
	<a class="navbar-brand" href="home.html">SGU - Sistema de Gestão Unimed</a>
</nav>
<section class="text-center" id="titulo">
	<h1 class="h1">Despesas e Receitas</h1>
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
			<br> <a href="home.html" class="btn btn-danger">Sair da
				consulta ao caixa</a>
		</div>
	</div>
	<div class="row" id="demonstrativo">
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="despesa">
			<p class="lead bold">
				<strong>TOTAL DE DESPESAS</strong> R$ XXX.XXX,00
			</p>
			<div id="accordion">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse" href="#collapseOne">
							SEDE ADMINISTRATIVA R$ xxx.xx,00 </a>
					</div>
					<div id="collapseOne" class="collapse show"
						data-parent="#accordion">
						<div class="card-body">
							<div id="accordion">
								<div class="card">
									<div class="card-header">
										<a class="card-link" data-toggle="collapse"
											href="#collapseOne"> MATERIAL DE ESCRITÓRIO R$ xxx.xx,00
										</a>
									</div>
									<div id="collapseOne" class="collapse show"
										data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											href="#collapseTwo"> DESPESAS ADMINISTRATIVAS R$
											xxx.xx,00 </a>
									</div>
									<div id="collapseTwo" class="collapse" data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											href="#collapseThree"> DESPESA COM PRODUÇÃO R$ xxx.xx,00
										</a>
									</div>
									<div id="collapseThree" class="collapse"
										data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseTwo"> CENTRO DE REFERENCIA R$ xxx.xx,00 </a>
					</div>
					<div id="collapseTwo" class="collapse" data-parent="#accordion">
						<div class="card-body">R$ xxx.xx,00</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseThree"> FARMÁCIA R$ xxx.xx,00 </a>
					</div>
					<div id="collapseThree" class="collapse" data-parent="#accordion">
						<div class="card-body">R$ xxx.xx,00</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6" id="receita">
			<p class="lead bold">
				<strong>TOTAL DE RECEITA</strong> R$ XXX.XXX,00
			</p>
			<div id="accordion">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse" href="#collapseOne">
							PLANO DE SAÚDE R$ xxx.xx,00 </a>
					</div>
					<div id="collapseOne" class="collapse show"
						data-parent="#accordion">
						<div class="card-body">
							<div id="accordion">
								<div class="card">
									<div class="card-header">
										<a class="card-link" data-toggle="collapse"
											href="#collapseOne"> PLANO EM CUSTO R$ xxx.xx,00 </a>
									</div>
									<div id="collapseOne" class="collapse show"
										data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											href="#collapseTwo"> PLANO XX R$ xxx.xx,00 </a>
									</div>
									<div id="collapseTwo" class="collapse" data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00 R$ xxx.xx,00</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											href="#collapseThree"> PLANO XXYY R$ xxx.xx,00 </a>
									</div>
									<div id="collapseThree" class="collapse"
										data-parent="#accordion">
										<div class="card-body">R$ xxx.xx,00</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseTwo"> CENTRO DE REFERENCIA R$ xxx.xx,00 </a>
					</div>
					<div id="collapseTwo" class="collapse" data-parent="#accordion">
						<div class="card-body">R$ xxx.xx,00</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseThree"> FARMACIA R$ xxx.xx,00 </a>
					</div>
					<div id="collapseThree" class="collapse" data-parent="#accordion">
						<div class="card-body">R$ xxx.xx,00</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br>