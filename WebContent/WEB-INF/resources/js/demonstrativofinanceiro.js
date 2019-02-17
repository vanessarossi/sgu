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
			$('#spinner').modal('hide');
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
		 })
		.fail(function(jqXHR, textStatus, msg){
			$('#spinner').modal('hide');
		    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});

}

