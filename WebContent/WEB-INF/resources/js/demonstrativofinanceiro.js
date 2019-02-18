$(document).ready(function(){

});

function enviarConsulta() {
	var dataInicial = $('#dataInicial').val();
	var dataFinal = $('#dataFinal').val();

	/** carregar info**/
	$.ajax({
			 url : '/sgu/fluxo/carregar/'+dataInicial+'/'+dataFinal,
		     type : 'get',
		beforeSend : function(){
				$('#spinner').modal('show');
			}
		})
		.done(function(response){
			for (var i = response.length - 1; i >= 0; i--) {
				$("#totalReceitaAnterior"+response[i]["codigoId"]).text(response[i]["totalReceitaAnterior"]);
				$("#totalReceita"+response[i]["codigoId"]).text(response[i]["totalReceita"]);
				$("#totalReceitaPrevisto"+response[i]["codigoId"]).text(response[i]["totalReceitaPrevisto"]);
				$("#totalDespesaAnterior"+response[i]["codigoId"]).text(response[i]["totalDespesaAnterior"]);
				$("#totalDespesa"+response[i]["codigoId"]).text(response[i]["totalDespesa"]);
				$("#totalDespesaPrevisto"+response[i]["codigoId"]).text(response[i]["totalDespesaPrevisto"]);

				/** Valor Líquido**/
				$("#totalLiquidoAnterior"+response[i]["codigoId"]).text(response[i]["totalLiquidoAnterior"]);
				$("#totalLiquido"+response[i]["codigoId"]).text(response[i]["totalLiquido"]);
				$("#totalLiquidoPrevisto"+response[i]["codigoId"]).text(response[i]["totalLiquidoPrevisto"]);

				for (var j = response[i]["receitas"].length - 1; j >= 0; j--) {
					$("#receitaAnterior"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valorAnterior"]);
					$("#receita"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valor"]);
				}

				for (var k = response[i]["despesas"].length - 1; k >= 0; k--) {
					$("#despesaAnterior"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valorAnterior"]);
					$("#despesa"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valor"]);
				}
			}

			carregarMovimentacao(dataInicial,dataFinal);
			
			$('#spinner').modal('hide');
		 })
		.fail(function(jqXHR, textStatus, msg){
			$('#spinner').modal('hide');
		    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
}

function carregarMovimentacao(dataInicial, dataFinal) {
	/** carregar info**/
	$.ajax({
			 url : '/sgu/fluxo/carregar/movimentacao/'+dataInicial+'/'+dataFinal,
		     type : 'get',
		beforeSend : function(){}
		})
		.done(function(response){
			for (var i = 0; i < response.length; i++) {
				$("#movSaldoLiquidoAnterior"+response[i]["codigoContaFluxo"]).text(response[i]["valorLiquidoAnterior"]);
				$("#movReceita"+response[i]["codigoContaFluxo"]).text("0");
				$("#movRespesa"+response[i]["codigoContaFluxo"]).text("0");
				$("#movSaldoBanco"+response[i]["codigoContaFluxo"]).text(response[i]["valorBanco"]);
				$("#movSaldoCaixa"+response[i]["codigoContaFluxo"]).text(response[i]["valorCaixa"]);
				$("#movSaldoTotal"+response[i]["codigoContaFluxo"]).text(response[i]["valorTotal"]);
				$("#movTransRealizada"+response[i]["codigoContaFluxo"]).text("0");
				$("#movTransRecebida"+response[i]["codigoContaFluxo"]).text("0");
			}
			calcularReceitaMovimentacao();
			calcularDespesaMovimentacao();
		 })
		.fail(function(jqXHR, textStatus, msg){
			$('#spinner').modal('hide');
		    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
}

function calcularReceitaMovimentacao() {
	var receitaSede = removerFormatacaoReal($("#totalReceita01").text());
	var receitaPostos = removerFormatacaoReal($("#totalReceita02").text());
	var receitaMedPrev = removerFormatacaoReal($("#totalReceita03").text());
	var receitaSdu = removerFormatacaoReal($("#totalReceita04").text());
	var receitaRemocao = removerFormatacaoReal($("#totalReceita05").text());
	var receitaDso = removerFormatacaoReal($("#totalReceita06").text());
	var receitaCduImg = removerFormatacaoReal($("#totalReceita07").text());
	var receitaVideo = removerFormatacaoReal($("#totalReceita08").text());
	var receitaCduLab = removerFormatacaoReal($("#totalReceita12").text());
	var receitaCru = removerFormatacaoReal($("#totalReceita09").text());
	var receitaNestle = removerFormatacaoReal($("#totalReceita10").text());
	var receitaCeu = removerFormatacaoReal($("#totalReceita11").text());
	var receitaOncologia = removerFormatacaoReal($("#totalReceita13").text());

	var totalReceitaContaSede = parseFloat(receitaSede) + parseFloat(receitaPostos) + parseFloat(receitaMedPrev) + parseFloat(receitaSdu)
							+ parseFloat(receitaRemocao) + parseFloat(receitaDso) + parseFloat(receitaCduImg) + parseFloat(receitaVideo)
							+ parseFloat(receitaCduLab) + parseFloat(receitaCru) + parseFloat(receitaNestle) + parseFloat(receitaCeu)
							+ parseFloat(receitaOncologia);

	var receitaFarmacia = removerFormatacaoReal($("#totalReceita90").text());
	var totalReceitaContaFarmacia = receitaFarmacia;

	var receitaOptica = removerFormatacaoReal($("#totalReceita91").text());
	var totalReceitaContaOptica = receitaOptica;

	var receitaHospital = removerFormatacaoReal($("#totalReceita70").text());
	var totalReceitaContaHospital = receitaHospital;

	$('#movReceita001').text(totalReceitaContaSede);
	$('#movReceita002').text(totalReceitaContaFarmacia);
	$('#movReceita003').text(totalReceitaContaOptica);
	$('#movReceita070').text(totalReceitaContaHospital);
}

function calcularDespesaMovimentacao() {
	var despesaSede = removerFormatacaoReal($("#totalDespesa01").text());
	var despesaPostos = removerFormatacaoReal($("#totalDespesa02").text());
	var despesaMedPrev = removerFormatacaoReal($("#totalDespesa03").text());
	var despesaSdu = removerFormatacaoReal($("#totalDespesa04").text());
	var despesaRemocao = removerFormatacaoReal($("#totalDespesa05").text());
	var despesaDso = removerFormatacaoReal($("#totalDespesa06").text());
	var despesaCduImg = removerFormatacaoReal($("#totalDespesa07").text());
	var despesaVideo = removerFormatacaoReal($("#totalDespesa08").text());
	var despesaCduLab = removerFormatacaoReal($("#totalDespesa12").text());
	var despesaCru = removerFormatacaoReal($("#totalDespesa09").text());
	var despesaNestle = removerFormatacaoReal($("#totalDespesa10").text());
	var despesaCeu = removerFormatacaoReal($("#totalDespesa11").text());
	var despesaOncologia = removerFormatacaoReal($("#totalDespesa13").text());

	var totalDespesaContaSede = parseFloat(despesaSede) + parseFloat(despesaPostos) + parseFloat(despesaMedPrev) + parseFloat(despesaSdu)
							+ parseFloat(despesaRemocao) + parseFloat(despesaDso) + parseFloat(despesaCduImg) + parseFloat(despesaVideo)
							+ parseFloat(despesaCduLab) + parseFloat(despesaCru) + parseFloat(despesaNestle) + parseFloat(despesaCeu)
							+ parseFloat(despesaOncologia);

	var despesaFarmacia = removerFormatacaoReal($("#totalDespesa90").text());
	var totalDespesaContaFarmacia = despesaFarmacia;

	var despesaOptica = removerFormatacaoReal($("#totalDespesa91").text());
	var totalDespesaContaOptica = despesaOptica;

	var despesaHospital = removerFormatacaoReal($("#totalDespesa70").text());
	var totalDespesaContaHospital = despesaHospital;

	$('#movDespesa001').text(totalDespesaContaSede);
	$('#movDespesa002').text(totalDespesaContaFarmacia);
	$('#movDespesa003').text(totalDespesaContaOptica);
	$('#movDespesa070').text(totalDespesaContaHospital);
}

function removerFormatacaoReal(valor) {
	while (valor.indexOf('.') != -1)
		valor = valor.replace('.', '');

	 while (valor.indexOf(',') != -1)
		valor = valor.replace(',', '.');

	return valor;
}
