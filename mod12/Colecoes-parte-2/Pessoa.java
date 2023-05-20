import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Pessoa implements Comparable<Pessoa> {
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}
	
	@Override
	public int compareTo(Pessoa pessoa) {
		return this.nome.compareTo(pessoa.getNome());
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
		
		Collections.sort(listaPessoaMasculina);
		
		listaPessoaMasculina.forEach(pessoa -> System.out.println(pessoa.getNome()));
		
		System.out.println();
		System.out.println("Grupo Feminino: ");
		
		Collections.sort(listaPessoaFeminina);
		
		listaPessoaFeminina.forEach(pessoa -> System.out.println(pessoa.getNome()));
		
		sc.close();
	}


	
}

enum Sexo { M, F }
