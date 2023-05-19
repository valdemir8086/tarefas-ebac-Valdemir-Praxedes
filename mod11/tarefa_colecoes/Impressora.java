import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Impressora {
	
	private static String LETRA_CORTE = ",";
	
	private List<String> listaPalavras;
	
	private Impressora() {
		
	}
	
	public List<String> obterListaOrdenada() {
		
		List<String> listaTemporaria = new ArrayList<>();
		 
		listaPalavras.forEach((palavra) -> listaTemporaria.add(palavra));
		
		Collections.sort(listaTemporaria);
		
		return listaTemporaria;
	}
	
	public static Impressora obterInstancia(String texto) {
		
		String[] palavras = texto.split(LETRA_CORTE);
		
		Impressora impressoraConsole = new Impressora();
		
		for(int x = 0; x < palavras.length; x++) {
			palavras[x] = palavras[x].trim();
		}
		
		List<String> listaPalavras = Arrays.asList(palavras);
		
		impressoraConsole.listaPalavras = listaPalavras;
		
		return impressoraConsole;
	}
	
	public static void main(String[] args) {
		System.out.print("Digite palavras separadas por (,): ");
		Scanner sc = new Scanner(System.in);
		
		String textoDigitado = sc.nextLine();
		
		Impressora impressora = Impressora.obterInstancia(textoDigitado);
		
		System.out.println("Lista ordenada:");
		
		impressora.obterListaOrdenada().forEach(palavra -> System.out.println(palavra));
		sc.close();
	}
}
