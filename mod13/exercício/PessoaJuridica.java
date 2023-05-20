import java.text.ParseException;

public class PessoaJuridica extends Pessoa {

	private String CNPJ;
	private String razaoSocial;
	private boolean situacaoCadastral;
	
	public PessoaJuridica(String nome, String sobrenome, String dataNascimento) throws ParseException {
		super(nome, sobrenome, dataNascimento);
	}
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public boolean isSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(boolean situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [CNPJ=" + CNPJ + ", Razao Social=" + razaoSocial 
				+ ", Situacao Cadastral=" + situacaoCadastral
				+ ", Nome=" + getNome() + ", Sobrenome=" + getSobrenome() + ", Data de Nascimento="
				+ getDataNascimento() + ", Idade=" + getIdade() + "]";
	}

}
