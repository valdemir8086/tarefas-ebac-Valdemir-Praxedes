package com.nota.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.nota.excecao.NotaNaoEncontradaException;
import com.nota.excecao.TituloNotaJaExistenteException;
import com.nota.excecao.TituloOuConteudoNotaEstaVazioException;
import com.nota.modelo.Nota;

public class NotaDAO {
	
		private final String NOME_DB = "NOTAS.DB";
		
		private File arquivo;
		
		public NotaDAO() throws IOException {
			arquivo = new File(NOME_DB);
			if(!arquivo.exists()) {
				arquivo.createNewFile();   
			}
		}
	    
	    public void salvar(String titulo, String conteudo) throws IOException, TituloNotaJaExistenteException, TituloOuConteudoNotaEstaVazioException, ClassNotFoundException {
	    	
	    	if(titulo.isBlank() || conteudo.isBlank()) {
	    		throw new TituloOuConteudoNotaEstaVazioException();
	    	}
	    	
	    	List<Nota> notas = buscarTodos();
	    	
	    	Nota notaBuscado = BuscaNotaPeloTitulo(notas, titulo);
	    	
	    	if(notaBuscado != null) {
	    		throw new TituloNotaJaExistenteException();
	    	}
	    	
	    	notas.add(new Nota(titulo, conteudo));
	    	
	    	salvar(notas);
	    }
	    
	    private void salvar(List<Nota> notas) throws IOException {
		 
	    	FileWriter fileWriter = new FileWriter(arquivo);
	    	
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    		    		
	        
	        for(Nota nota: notas) {
	        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	   	        
	   	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        	oos.writeObject(nota);
	        	
		        oos.close();
		        
		        String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
		        
		        bufferedWriter.write(base64+"\n");
	        }
	        

	        bufferedWriter.close();    
	    }
	    
	    public void excluir(String titulo) throws FileNotFoundException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
	    	List<Nota> notas = buscarTodos();
	    	
	    	Nota nota = BuscaNotaPeloTitulo(notas, titulo);
	    	
	    	if(nota == null) {
	    		throw new NotaNaoEncontradaException();
	    	}
	    	
	    	notas.remove(nota);
	    	
	    	salvar(notas);
	    	
	    }
	    
	    public void editar(String titulo, String conteudo) throws TituloOuConteudoNotaEstaVazioException, FileNotFoundException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
	    	if(titulo.isBlank() || conteudo.isBlank()) {
	    		throw new TituloOuConteudoNotaEstaVazioException();
	    	}
	    	
	    	List<Nota> notas = buscarTodos();
	    	
	    	Nota notaBuscado = BuscaNotaPeloTitulo(notas, titulo);
	    	
	    	if(notaBuscado == null) {
	    		throw new NotaNaoEncontradaException();
	    	}
	    	
	    	notaBuscado.setConteudo(conteudo);
	    	
	    	salvar(notas);
	    }
	    
	    private Nota BuscaNotaPeloTitulo(List<Nota> notas, String titulo) {
	    	
	    	Nota notaBuscado = null;
	    	
	    	for(Nota nota : notas) {
	    		if(nota.getTitulo().equalsIgnoreCase(titulo)) {
	    			notaBuscado = nota;
	    			break;
	    		}
	    	}
	    	
	    	return notaBuscado;
	    }
	    
	    public Nota buscarPorTitulo(String titulo) throws FileNotFoundException, IOException, NotaNaoEncontradaException, ClassNotFoundException {
	    	List<Nota> notas = buscarTodos();
	    	
	    	Nota nota = BuscaNotaPeloTitulo(notas, titulo);
	    	
	    	if(nota == null) {
	    		throw new NotaNaoEncontradaException();
	    	}
	    	
	    	return nota;
	    }
	    
	    public List<Nota> buscarTodos() throws FileNotFoundException, IOException, ClassNotFoundException {
	    	List<Nota> notas = new ArrayList<>();
	    	
	        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                byte[] decodedBytes = Base64.getDecoder().decode(linha);
	                
	                ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);
	                ObjectInputStream ois = new ObjectInputStream(bais);

	                Nota nota = (Nota) ois.readObject();

	                notas.add(nota);
	            }
	        } 
	        
	        return notas;
	    }

}
