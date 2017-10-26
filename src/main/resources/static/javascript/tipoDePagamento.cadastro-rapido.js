var Financeiro = Financeiro || {};

Financeiro.TipoDePagamentoNovo = (function() {
	
	function TipoDePagamentoNovo() {
		this.modal = $('#modal-cadastro-rapido-tipo-de-pagamento');
		this.botaoSalvar = $('.js-novo-tipo-de-pagamento-btn');
	}
	
	TipoDePagamentoNovo.prototype.iniciar = function (){
		
	}
	
	return TipoDePagamentoNovo;
	
});

$(function() {
	
	var tipoDePagamentoNovo = new Financeiro.TipoDePagamentoNovo();
	tipoDePagamentoNovo.iniciar();
	
});