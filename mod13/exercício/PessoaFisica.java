import java.text.ParseException;

public class PessoaFisica extends Pessoa {
	
	private String CPF;

	public PessoaFisica(String nome, String sobrenome, String dataNascimento) throws ParseException {
		super(nome, sobrenome, dataNascimento);
	}
	
	public PessoaFisica(String nome, String sobrenome, String dataNascimento, String cpf) throws ParseException {
		super(nome, sobrenome, dataNascimento);
		this.setCPF(cpf);
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "PessoaFisica [CPF=" + CPF + ", Nome=" + getNome() + ", Sobrenome=" + getSobrenome()
		+ ", Data de Nascimento=" + getDataNascimento() + ", Idade=" + getIdade() + "]";
	}

}
