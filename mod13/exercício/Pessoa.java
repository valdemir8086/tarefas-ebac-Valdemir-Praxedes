import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Pessoa {
	
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	
	private SimpleDateFormat formataDataParaFormatadoBrasil = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pessoa(String nome, String sobrenome, String dataNascimento) throws ParseException {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setDataNascimento(dataNascimento);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDataNascimento() {
		return formataDataParaFormatadoBrasil.format(dataNascimento);
	}

	public void setDataNascimento(String dataNascimento) throws ParseException {
			this.dataNascimento = formataDataParaFormatadoBrasil.parse(dataNascimento);
	}
	
	public int getIdade() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		
		int anoAtual = calendar.get(Calendar.YEAR);
		
		calendar.setTime(dataNascimento);
		
		int anoDoNascimento = calendar.get(Calendar.YEAR);
		
		return anoAtual-anoDoNascimento;
	}
	
}
