package com.nota.modelo;

import java.io.Serializable;

public class Nota implements Serializable {
	

	private String titulo;
	private String conteudo;
	
	private static final long serialVersionUID = -8826301888009673968L;
	
	public Nota() {
		
	}
	
	public Nota(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
