package com.nota.excecao;

public class TituloNotaJaExistenteException extends Exception {

	public TituloNotaJaExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public TituloNotaJaExistenteException() {
		super("Nota já existe");
	}

}
