import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		PessoaFisica pessoaFisica = new PessoaFisica("João", "Carvalho", "10/10/1990");
		
		pessoaFisica.setCPF("12345678910");
		
		System.out.println(pessoaFisica);
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica("Maria", "Silva", "20/09/1991");
		
		pessoaJuridica.setCNPJ("123131414141242");
		pessoaJuridica.setRazaoSocial("Laboratórios Nova Era");
		pessoaJuridica.setSituacaoCadastral(true);

		System.out.println(pessoaJuridica);
	}

}
