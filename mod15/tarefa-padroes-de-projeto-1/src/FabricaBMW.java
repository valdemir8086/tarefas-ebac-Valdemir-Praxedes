
public class FabricaBMW extends FabricaCarros {

	@Override
	public Carro criarCarro() {
	
		return new BMW(2022, "Prata");
	}

}
