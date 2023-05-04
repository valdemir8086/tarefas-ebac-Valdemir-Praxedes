package com.nota;

import java.io.IOException;

import com.nota.controle.dto.Comando;
import com.nota.controler.NotaControler;
import com.nota.excecao.NotaNaoEncontradaException;
import com.nota.excecao.TituloNotaJaExistenteException;
import com.nota.excecao.TituloOuConteudoNotaEstaVazioException;

public class Principal {

	private final static int POSICAO_COMANDO = 0;
	private final static int POSICAO_PARAMETRO_UM_COMANDO = 1;
	private final static int POSICAO_PARAMETRO_DOIS_COMANDO = 2;
	
	public static void main(String[] argumentos) throws IOException, TituloNotaJaExistenteException, TituloOuConteudoNotaEstaVazioException, NotaNaoEncontradaException, ClassNotFoundException {
				
		
		if(argumentos.length == 0) {
			help();
			throw new RuntimeException("Não foi passado os parametros!");
			
		}
		
		String comando = argumentos[POSICAO_COMANDO];
			
		if(argumentos.length <= POSICAO_PARAMETRO_UM_COMANDO) {
			help();
			throw new RuntimeException("Sintaxe incorreta!");
		}
			
		String parametroUmComando = argumentos[POSICAO_PARAMETRO_UM_COMANDO];
		
		String parametroDois = (argumentos.length > POSICAO_PARAMETRO_DOIS_COMANDO) ? argumentos[POSICAO_PARAMETRO_DOIS_COMANDO]: null;
		
		NotaControler notaController = new NotaControler();
		
		String resposta = notaController.fazerAlgumaAcao(new Comando(comando, parametroUmComando, parametroDois));
		
		System.out.println(resposta);
		
	}
	
	   public static void help() {
	        System.out.println("Como executar\n");
	        System.out.println("java notaApp.jar -jar --criar \"nota\" \"ok\"\n");
	        System.out.println("comando\t\tabreviado\texemplo");
	        System.out.println("--criar\t\t-c\t\t--criar ou -c nota1 \"conteudo\"");
	        System.out.println("--pesquisar\t-p\t\t--pesquisar ou -p \"nome da nota\"");
	        System.out.println("--deletar\t-d\t\t--deletar ou -d \"nome da nota\"");
	        System.out.println("--alterar\t-a\t\t--alterar ou -a \"nome da nota\" \"conteudo\"\n\n");
	    }

}
