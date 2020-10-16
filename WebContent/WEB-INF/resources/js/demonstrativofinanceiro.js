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

/** analisar aqui  **/
function carregarMovimentacao(dataInicial, dataFinal) {
	if(dataInicial != '' && dataInicial != null && dataFinal != '' && dataFinal != null){
		$.ajax({
				 url : '/sgu/fluxo/carregar/movimento/'+dataInicial+'/'+dataFinal,
			     type : 'get',
			beforeSend : function(){}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {

					$("#movSaldoAnterior"+response[i]["codigoId"]).text(parseFloat(response[i]["saldoLiquidoAnterior"]).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
					$("#movReceita"+response[i]["codigoId"]).text(parseFloat(response[i]["totalReceita"]).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
					$("#movDespesa"+response[i]["codigoId"]).text(parseFloat(response[i]["totalDespesa"]).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
					$("#movSaldoAtual"+response[i]["codigoId"]).text(parseFloat(response[i]["saldoLiquido"]).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }));
				}
			 })
			.fail(function(jqXHR, textStatus, msg){
				$('#spinner').modal('hide');
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
			});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
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