package com.nota.servico;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.nota.dao.NotaDAO;
import com.nota.excecao.NotaNaoEncontradaException;
import com.nota.excecao.TituloNotaJaExistenteException;
import com.nota.excecao.TituloOuConteudoNotaEstaVazioException;
import com.nota.modelo.Nota;

public class NotasServico {
	
	NotaDAO dao;
	
	public NotasServico() throws IOException {
		 dao = new NotaDAO();
	}
	
	public String criarNota(String titulo, String conteudo) throws IOException, TituloNotaJaExistenteException, TituloOuConteudoNotaEstaVazioException, ClassNotFoundException {
	
		dao.salvar(titulo, conteudo);
		
		return "Nota criada com sucesso";
	}
	
	public String apagarNota(String titulo) throws FileNotFoundException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
		dao.excluir(titulo);
		return "Nota apagada com sucesso";
	}
	
	public String buscaNota(String titulo) throws FileNotFoundException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
		Nota nota = dao.buscarPorTitulo(titulo);
		return "Nota: ".concat(nota.getTitulo()).concat("\nConteudo: ").concat(nota.getConteudo());
	}
	
	public String editarNota(String titulo, String conteudo) throws FileNotFoundException, TituloOuConteudoNotaEstaVazioException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
		dao.editar(titulo, conteudo);
		return "Nota editada com sucesso";
	}
	
	
	
	

}
