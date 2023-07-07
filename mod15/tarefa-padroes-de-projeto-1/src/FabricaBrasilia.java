
public class FabricaBrasilia extends FabricaCarros {

	@Override
	public Carro criarCarro() {
		return new Brasilia(1980, "Amarelo");
	}

}
