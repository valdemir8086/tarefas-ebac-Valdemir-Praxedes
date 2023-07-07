
public abstract class Carro {
		private String marca;
	    private String modelo;
	    private int ano;
	    private String cor;


	    public Carro(String marca, String modelo, int ano, String cor) {
	        this.marca = marca;
	        this.modelo = modelo;
	        this.ano = ano;
	        this.cor = cor;
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public String getModelo() {
	        return modelo;
	    }

	    public int getAno() {
	        return ano;
	    }

	    public String getCor() {
	        return cor;
	    }

}
