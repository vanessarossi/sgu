$(document).ready(function() {
	    $('#tabelaComentario').DataTable({
	    	"oLanguage": {
	    		"sUrl": "/sgu/resources/js/util/pt-BR.json"
	    	},
	    	"bAutoWidth":true,
	        "bLengthChange": false,
	        "bPaginate": true,
	        "bFilter": true,
	        "bSort": false,
	        "bInfo": true,
	        "processing": true,
	        "bJQueryUI": false,
	        "sPaginationType": "full_numbers",
	        "iDisplayLength":  10,
	    });
	} );