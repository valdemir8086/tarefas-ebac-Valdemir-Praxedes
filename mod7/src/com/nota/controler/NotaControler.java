package com.nota.controler;

import java.io.IOException;

import com.nota.controle.dto.Comando;
import com.nota.excecao.NotaNaoEncontradaException;
import com.nota.excecao.TituloNotaJaExistenteException;
import com.nota.excecao.TituloOuConteudoNotaEstaVazioException;
import com.nota.servico.NotasServico;

public class NotaControler {
	
	public String fazerAlgumaAcao(Comando comando) throws IOException, TituloNotaJaExistenteException, TituloOuConteudoNotaEstaVazioException, NotaNaoEncontradaException, ClassNotFoundException {
		NotasServico servico = new NotasServico();
		
		switch (comando.comando()) {
		case "--criar":
		case "-c":
			return servico.criarNota(comando.parametroUm(), comando.parametroDois());
		case "--pesquisar":
		case "-p":
			 return servico.buscaNota(comando.parametroUm());
		case "--deletar":
		case "-d":
			 return servico.apagarNota(comando.parametroUm());
		case "--alterar":
		case "-a":
			 return servico.editarNota(comando.parametroUm(), comando.parametroDois());
		default:
			throw new IllegalArgumentException("Comando invalido ou sixtaxe invalida!");
		}
	}

}
