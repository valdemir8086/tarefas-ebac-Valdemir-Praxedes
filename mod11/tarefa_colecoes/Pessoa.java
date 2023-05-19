import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa {
	
	private String nome;
	private Sexo sexo;
	
	public Pessoa(String nome, Sexo sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public static void main(String[] args) {
		System.out.print("Digite o nome de pessoa acompanhada de seus sexo exemplo joão-m, maria-f: ");
		Scanner sc = new Scanner(System.in);
		
		String textoDigitado = sc.nextLine();
		
		String[] textoQuebradoPorVirgula = textoDigitado.split(",");
		
		List<Pessoa> listaPessoaMasculina = new ArrayList<>();
		List<Pessoa> listaPessoaFeminina = new ArrayList<>();
		
		for(String texto : textoQuebradoPorVirgula) {
			String[] textoQuebradoPorTraco = texto.split("-");
			
			final int NOME = 0;
			final int SEXO = 1;
			
			String nome = textoQuebradoPorTraco[NOME].trim();
			String sexo = textoQuebradoPorTraco[SEXO].toUpperCase().trim();
			
			Pessoa pessoa = new Pessoa(nome, Sexo.valueOf(sexo));
			
			if(pessoa.getSexo() == Sexo.M) {
				listaPessoaMasculina.add(pessoa);
			} else {
				listaPessoaFeminina.add(pessoa);
			}
			
		}
		System.out.println();
		System.out.println("Grupo Masculino: ");
		
		listaPessoaMasculina.forEach(pessoa -> System.out.println(pessoa.getNome()));
		
		System.out.println();
		System.out.println("Grupo Feminino: ");
		
		listaPessoaFeminina.forEach(pessoa -> System.out.println(pessoa.getNome()));
		
		sc.close();
	}
	
}

enum Sexo { M, F }
