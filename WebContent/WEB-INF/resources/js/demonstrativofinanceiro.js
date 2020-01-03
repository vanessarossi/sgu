$(document).ready(function(){
	    $('[data-toggle="popover"]').popover();   
});

function montarInfo(comentario) {
	if (comentario != "" && comentario != " ") {
		return "<a class='badge badge-info info-fluxo' onclick=abrirComentario("+comentario+")><i class='fas fa-info'></i></a>";
	}else{
		return '';
	}

}

function enviarConsulta() {
	var dataInicial = $('#dataInicial').val();
	var dataFinal = $('#dataFinal').val();
	if(dataInicial != '' && dataInicial != null && dataFinal != '' && dataFinal != null){
		$.ajax({
				 url : '/sgu/fluxo/carregar/'+dataInicial+'/'+dataFinal,
			     type : 'get',
			beforeSend : function(){
					$('#spinner').modal('show');
				}
			})
			.done(function(response){
				for (var i = response.length - 1; i >= 0; i--) {
					$("#totalReceitaAnterior"+response[i]["codigoId"]).text(response[i]["valorReceitaAnterior"]);
					$("#totalReceita"+response[i]["codigoId"]).text(response[i]["valorReceita"]);
					$("#totalReceitaPrevisto"+response[i]["codigoId"]).text(response[i]["valorReceitaPrevisao"]);
					$("#totalDespesaAnterior"+response[i]["codigoId"]).text(response[i]["valorDespesaAnterior"]);
					$("#totalDespesa"+response[i]["codigoId"]).text(response[i]["valorDespesa"]);
					$("#totalDespesaPrevisto"+response[i]["codigoId"]).text(response[i]["valorDespesaPrevisao"]);

					/** Valor Líquido**/
					$("#totalLiquidoAnterior"+response[i]["codigoId"]).text(response[i]["valorLiquidoAnterior"]);
					$("#totalLiquido"+response[i]["codigoId"]).text(response[i]["valorLiquido"]);
					$("#totalLiquidoPrevisto"+response[i]["codigoId"]).text(response[i]["valorLiquidoPrevisao"]);

					for (var j = response[i]["receitas"].length - 1; j >= 0; j--) {
						
						$("#receitaAnterior"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valorAnterior"]);
						$("#receitaAnterior"+response[i]["receitas"][j]["codigoId"]).append(montarInfo(response[i]["receitas"][j]["comentarioAnterior"]));
						
						$("#receita"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valor"]);
						$("#receita"+response[i]["receitas"][j]["codigoId"]).append(montarInfo(response[i]["receitas"][j]["comentario"]));
						
						$("#receitaPrevisto"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valorPrevisao"]);
						$("#receitaPrevisto"+response[i]["receitas"][j]["codigoId"]).append(montarInfo(response[i]["receitas"][j]["comentarioPrevisao"]));
					}

					for (var k = response[i]["despesas"].length - 1; k >= 0; k--) {
						$("#despesaAnterior"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valorAnterior"]);
						$("#despesaAnterior"+response[i]["despesas"][k]["codigoId"]).append(montarInfo(response[i]["despesas"][k]["comentarioAnterior"]));

						$("#despesa"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valor"]);
						$("#despesa"+response[i]["despesas"][k]["codigoId"]).append(montarInfo(response[i]["despesas"][k]["comentario"]));

						$("#despesaPrevisto"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valorPrevisao"]);
						$("#despesaPrevisto"+response[i]["despesas"][k]["codigoId"]).append(montarInfo(response[i]["despesas"][k]["comentarioPrevisao"]));

						
					}
				}
				
				carregarMovimentacao(dataInicial,dataFinal);
				
				$('#spinner').modal('hide');
			 })
			.fail(function(jqXHR, textStatus, msg){
				$('#spinner').modal('hide');
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
			});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
}

function carregarMovimentacao(dataInicial, dataFinal) {
	if(dataInicial != '' && dataInicial != null && dataFinal != '' && dataFinal != null){
		$.ajax({
				 url : '/sgu/fluxo/carregar/movimento/'+dataInicial+'/'+dataFinal,
			     type : 'get',
			beforeSend : function(){}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {
					$("#movSaldoLiquidoAnterior"+response[i]["codigoId"]).text(response[i]["saldoLiquidoAnterior"]);
					$("#movSaldoBanco"+response[i]["codigoId"]).text(response[i]["saldoBanco"]);
					$("#movSaldoCaixa"+response[i]["codigoId"]).text(response[i]["saldoCaixa"]);
					$("#movSaldoTotal"+response[i]["codigoId"]).text(response[i]["saldoLiquido"]);
					$("#movTransRealizada"+response[i]["codigoId"]).text(response[i]["saldoTranferenciaRealizada"]);
					$("#movTransRecebida"+response[i]["codigoId"]).text(response[i]["saldoTranferenciaRecebida"]);
				}
				calcularReceitaMovimentacao();
				calcularDespesaMovimentacao();
			 })
			.fail(function(jqXHR, textStatus, msg){
				$('#spinner').modal('hide');
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
			});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
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

	$('#movReceita001').text(parseFloat(totalReceitaContaSede).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movReceita002').text(parseFloat(totalReceitaContaFarmacia).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movReceita003').text(parseFloat(totalReceitaContaOptica).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movReceita070').text(parseFloat(totalReceitaContaHospital).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
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

	$('#movDespesa001').text(parseFloat(totalDespesaContaSede).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movDespesa002').text(parseFloat(totalDespesaContaFarmacia).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movDespesa003').text(parseFloat(totalDespesaContaOptica).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
	$('#movDespesa070').text(parseFloat(totalDespesaContaHospital).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
}

function removerFormatacaoReal(valor) {
	while (valor.indexOf('.') != -1)
		valor = valor.replace('.', '');

	 while (valor.indexOf(',') != -1)
		valor = valor.replace(',', '.');

	return valor;
}


function validaValor(valorAnterior, valor, valorPrevisto) {
	if(valorAnterior == '0,00' &&  valor == '0,00' && valorPrevisto == '0,00'){
		return true;
	}else{
		return false;
	}
}


function pesquisarReceita(codigoNivel) {
	var dataInicial = $('#dataInicial').val();
	var dataFinal = $('#dataFinal').val();
	if(dataInicial != '' && dataInicial != null && dataFinal != '' && dataFinal != null){
		$.ajax({
				url : '/sgu/fluxo/carregar/receita/'+codigoNivel+'/'+dataInicial+'/'+dataFinal,
			    type : 'get',
			beforeSend : function(){
					$('#tabelaQuintoNivel > tbody >tr').remove();
				}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {
					if(validaValor(response[i]["valorAnterior"] , response[i]["valor"] , response[i]["valorPrevisto"]) === false){
						var row = '<tr>';
				                row += "<td>"+response[i]["descricao"]+"</td>";
				                row += "<td>"+response[i]["valorAnterior"]+"</td>";
				                row += "<td>"+response[i]["valor"]+"</td>";
				                row += "<td>"+response[i]["valorPrevisto"]+"</td>";
								row += "</tr>";

						$('#tabelaQuintoNivel > tbody').append(row);
					}
				}
				$('#quintoNivel').modal('show');
			})
			.fail(function(jqXHR, textStatus, msg){
				$('#spinner').modal('hide');
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
}

function pesquisarDespesa(codigoNivel) {
	var dataInicial = $('#dataInicial').val();
	var dataFinal = $('#dataFinal').val();
	if(dataInicial != '' && dataInicial != null && dataFinal != '' && dataFinal != null){
		$.ajax({
				 url : '/sgu/fluxo/carregar/despesa/'+codigoNivel+'/'+dataInicial+'/'+dataFinal,
			     type : 'get',
			beforeSend : function(){
					$('#tabelaQuintoNivel > tbody >tr').remove();
				}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {
					if(validaValor(response[i]["valorAnterior"] , response[i]["valor"] , response[i]["valorPrevisto"]) === false){
						var row = '<tr>';
				                row += "<td>"+response[i]["descricao"]+"</td>";
				                row += "<td>"+response[i]["valorAnterior"]+"</td>";
				                row += "<td>"+response[i]["valor"]+"</td>";
				                row += "<td>"+response[i]["valorPrevisto"]+"</td>";
								row += "</tr>";
						$('#tabelaQuintoNivel > tbody').append(row);
					}
				}
				$('#quintoNivel').modal('show');
			})
			.fail(function(jqXHR, textStatus, msg){
				$('#spinner').modal('hide');
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
}

function abrirComentario(id) {
	$.ajax({
			 url : '/sgu/fluxo/pesquisa/comentario/'+id,
		     type : 'get',
		beforeSend : function(){
				$('#textoComentario').text("");
			}
		})
		.done(function(response){
			var codigo = response["codigo"];
			var competencia = response["competencia"];
			var comentario = response["comentario"];
			
			$('#textoComentario').val(comentario);
			$('#comentario').modal('show');
		 })
		.fail(function(jqXHR, textStatus, msg){
			('#comentario').modal('hide');
		    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
}