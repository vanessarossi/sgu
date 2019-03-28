$(document).ready(function(){
	$('#espera').hide();
});		

function calcular() {
	var data = $('#data').val();
	if (data != '' && data != null) {
		$.ajax({
				 url : '/sgu/despesareceita/calcular/segundoNivel/'+data,
			     type : 'get',
			beforeSend : function(){}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {
					$("#"+response[i]["codigo"]).text();
					$("#"+response[i]["codigo"]).text(response[i]["valorTotal"]);
				}
			 })
			.fail(function(jqXHR, textStatus, msg){
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
			});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
}

function buscarDetalhes(codigoPrimeiroNivel, codigoNivel) {
	var data = $('#data').val();
	if (data != '' && data != null) {
		$.ajax({
				 url : '/sgu/despesareceita/calcular/detalhe/'+codigoPrimeiroNivel+'/'+codigoNivel+'/'+data,
			     type : 'get',
			beforeSend : function(){
					$('#espera').show();
					$('#tabelaDetalhe > tbody >tr').remove();
				}
			})
			.done(function(response){
				for (var i = 0; i < response.length; i++) {
					if(response[i]["valorTotal"] != '0,00'){
						var row = '<tr>';
				            row += "<td>"+response[i]["descricao"]+"</td>";
				            row += "<td>"+response[i]["valorTotal"]+"</td>";
							row += "</tr>";
						$('#tabelaDetalhe > tbody').append(row);
					}
				}
				$('#espera').hide();
				$('#detalhe').modal('show');
			})
			.fail(function(jqXHR, textStatus, msg){
				$('#espera').hide();
			    alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
		});
	}else{
		alert("POR FAVOR, ESCOLHA UMA DATA");
	}
}
