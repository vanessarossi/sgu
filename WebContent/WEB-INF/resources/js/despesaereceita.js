$(document).ready(function(){
    $("#myCollapsible").collapse('show');
});


function expandirTerceiroNivel(codigoPrimeiroNivel,codigoSegundoNivel){
	$.ajax({
			 url : '/sgu/despesareceita/pesquisaTerceiroNivel/'+codigoPrimeiroNivel+'/'+codigoSegundoNivel,
		     type : 'get',
		beforeSend : function(){

		  }
		})
		.done(function(response){
        montarNivel(response);
		 })
		.fail(function(jqXHR, textStatus, msg){
		          alert("Ocorreu um erro, entre em contato com o desenvolvedor do sistema");
	});
}


function montarNivel(response) {
  for (var i = 0; i < response.length; i++) {
    var codigoPrimeiroNivel = response[i]["codigoPrimeiroNivel"];
    var codigoSegundoNivel = response[i]["codigoSegundoNivel"];
    var codigoNivel = response[i]["codigoNivel"];
    var codigo = response[i]["codigo"];
    var descricao = response[i]["descricao"];

    console.log(descricao);
  }
}




$("#myCollapsible").on('hidden.bs.collapse', function(){

    alert("Collapsible element has been completely closed.");

});
