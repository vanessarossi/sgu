
$(document).ready(function(){
	$('.segundoNivelDespesa').on('click', function (e) {
	  e.preventDefault()
	  var idExpandir = $(this).get(0).id;


	});
})


function expandirTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel){
	var dataSaldo = $('#dataSaldo').text();
		dataSaldo = dataSaldo.replace(/\//g,'-');

	$.ajax({
			 url : '/sgu/despesareceita/pesquisaTerceiroNivel/'+codigoPrimeiroNivel+'/'+codigoSegundoNivel+'/'+dataSaldo,
		     type : 'get',
		beforeSend : function(){
			
		  }
		})
		.done(function(response){

			for (var i = 0; i < response.length; i++) {
			    var codigoPrimeiroNivel = response[i]["codigoPrimeiroNivel"];
			    var codigoSegundoNivel = response[i]["codigoSegundoNivel"];
			    var codigoNivel = response[i]["codigoNivel"];
			    var codigo = response[i]["codigo"];
			    var descricao = response[i]["descricao"];
			    var valorTotal = response[i]["valorTotal"];
			
			    

				$('#terceiroNivelDespesa_'+codigoPrimeiroNivel+'_'+codigoSegundoNivel).append(tr);
			}

		 })
		.fail(function(jqXHR, textStatus, msg){
		          alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
	});
}


function monstarTabela(idTabela) {
	var tabela = "<table class='table table-hover table-sm' id="+idTabela+">";
		tabela =+ "<tbody>";
		tabela =+ "</tbody>";
		tabela =+ "</table>";

	return table;
}

function montarLinhaTerceiroNivel(descricaoPrimeiroNivel,codigoSegundoNivel,codigoNivel,codigo, descricao, valorTotal) {

}


				
				
				
			