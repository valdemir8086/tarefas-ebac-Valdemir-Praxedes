package exercicio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Media {
	
	private double nota1 = Double.NaN;
	private double nota2 = Double.NaN;
	private double nota3 = Double.NaN;
	private double nota4 = Double.NaN;
	
	private final int QUANTIDADE_DE_NOTAS = 4;
	

	private void adicionarNota(double nota) {
		
		if(!isNumeroEntreZeroADez(nota)) {
			throw new RuntimeException("O número precisa estar dentro do intervalo de 0 a 10.");
		}
		
		if(Double.isNaN(nota1)) nota1 = nota;
		else if(Double.isNaN(nota2)) nota2 = nota;
		else if(Double.isNaN(nota3)) nota3 = nota;
		else if(Double.isNaN(nota4)) nota4 = nota;
		else {
			throw new RuntimeException("Todas as notas foram preenchidas");
		}
	}
	
	private boolean isNumeroEntreZeroADez(double numero) {
		return numero >= 0.0d && numero <= 10.0d;
	}

	public double getMedia() {
		
		if(Double.isNaN(nota1) || Double.isNaN(nota2) || Double.isNaN(nota3) || Double.isNaN(nota4)) {
			throw new RuntimeException("Para obter a média, é necessário preencher todas as notas.");
		}
		
		return (nota1+nota2+nota3+nota4) / QUANTIDADE_DE_NOTAS;
	}
	
	public static boolean entrarComDigito(Media media) {
		Scanner sc = new Scanner(System.in);
		boolean deuErro = false;
		try {
			media.adicionarNota(sc.nextDouble());
		} catch (InputMismatchException e) {
			deuErro = true;
			System.out.println("Por favor, certifique-se de digitar apenas valores numéricos. Caso haja casas decimais no valor digitado, utilize a vírgula (,) em vez do ponto (.) como separador decimal.");
		} 
		catch (RuntimeException e) {
			deuErro = true;
			System.out.println(e.getMessage());
		}
		
		return deuErro;
		
	}
	
	
	public static void main(String[] args) {
		Media media = new Media();		
		do {
			System.out.print("Digite a primeira nota: ");
		} while (entrarComDigito(media));
		
		
		do {
			System.out.print("Digite a segunda nota: ");
		} while (entrarComDigito(media));
		
		do {
			System.out.print("Digite a terceira nota: ");
		} while (entrarComDigito(media));
		
		do {
			System.out.print("Digite a quarta nota: ");
		} while (entrarComDigito(media));
		
		StringBuilder sb = new StringBuilder("A sua media é ");
		
		sb.append(media.getMedia());
		
		sb.append("!");
		
		System.out.println(sb.toString());
		
		
		
	}
}
