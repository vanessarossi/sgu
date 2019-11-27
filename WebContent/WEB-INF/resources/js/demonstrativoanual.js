$(document).ready(function(){
	    $('[data-toggle="popover"]').popover();   
});

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
					$("#totalReceita"+response[i]["codigoId"]).text(response[i]["valorReceita"]);
					$("#totalDespesa"+response[i]["codigoId"]).text(response[i]["valorDespesa"]);

					/** Valor Líquido**/
					$("#totalLiquido"+response[i]["codigoId"]).text(response[i]["valorLiquido"]);

					for (var j = response[i]["receitas"].length - 1; j >= 0; j--) {
						$("#receita"+response[i]["receitas"][j]["codigoId"]).text(response[i]["receitas"][j]["valor"]);
					}

					for (var k = response[i]["despesas"].length - 1; k >= 0; k--) {
						$("#despesa"+response[i]["despesas"][k]["codigoId"]).text(response[i]["despesas"][k]["valor"]);
					}
				}
				
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

function validaValor(valor) {
	if(valor === '0,00'){
		return true;
	}else{
		return false;
	}
}

function removerFormatacaoReal(valor) {
	while (valor.indexOf('.') != -1)
		valor = valor.replace('.', '');

	 while (valor.indexOf(',') != -1)
		valor = valor.replace(',', '.');

	return valor;
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
					if(validaValor(response[i]["valor"]) === false){
						var row = '<tr>';
				                row += "<td>"+response[i]["descricao"]+"</td>";
				                row += "<td>"+response[i]["valor"]+"</td>";
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
					if(validaValor(response[i]["valor"]) === false){
						var row = '<tr>';
				                row += "<td>"+response[i]["descricao"]+"</td>";
				                row += "<td>"+response[i]["valor"]+"</td>";
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