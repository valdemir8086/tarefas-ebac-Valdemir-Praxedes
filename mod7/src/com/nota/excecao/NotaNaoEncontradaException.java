package com.nota.excecao;

public class NotaNaoEncontradaException extends Exception {

	public NotaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public NotaNaoEncontradaException() {
		super("Nota não encontrada!");
	}

}
