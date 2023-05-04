package com.nota.excecao;

public class TituloOuConteudoNotaEstaVazioException extends Exception {

	public TituloOuConteudoNotaEstaVazioException(String mensagem) {
		super(mensagem);
	}
	
	public TituloOuConteudoNotaEstaVazioException() {
		super("Titulo ou Couteudo do nota esta vazio!");
	}
	

}
