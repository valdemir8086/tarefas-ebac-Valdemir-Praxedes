package br.com.estudo;

public class PrimeiraClasse {

	public static void main(String[] args) {
	
		if(args.length == 0) {
		 throw new RuntimeException("É necessario passar o nome como paramentro!");
		}
		
		String nome = args[0];
		System.out.println("Olá, ".concat(nome));

	}

}
