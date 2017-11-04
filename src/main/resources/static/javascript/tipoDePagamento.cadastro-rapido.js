var Financeiro = Financeiro || {};

Financeiro.TipoDePagamentoNovo = (function() {
	
	function TipoDePagamentoNovo() {
		this.modal = $('#modal-cadastro-rapido-tipo-de-pagamento');
		this.botaoSalvar = $('.js-novo-tipo-de-pagamento-btn');
		this.botaoAbrirModal = $('.js-abrir-modal-novo-tipo');
		this.comboTipoDePagamento = $('#tipoDePagamento');
		this.inputNovoPagamento = $('#input-descricao-do-novo-tipo-de-pagamento');
		this.conteinerMensagemErro = $('js-mensagem-de-erro');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
	};
	
	TipoDePagamentoNovo.prototype.iniciar = function (){
		
	};
	
	return TipoDePagamentoNovo;
	
});

$(function() {
	
	var tipoDePagamentoNovo = new Financeiro.TipoDePagamentoNovo();
	tipoDePagamentoNovo.iniciar();
	
});