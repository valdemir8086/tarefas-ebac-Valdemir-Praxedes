
public class Principal {

	public static void main(String[] args) {
		FabricaCarros  fabrica = new FabricaBMW();
		
		Carro bmw = fabrica.criarCarro();
		System.out.println("-----------------");
		System.out.println(bmw.getMarca()); 
		System.out.println(bmw.getModelo()); 
		System.out.println(bmw.getAno()); 
		System.out.println(bmw.getCor());
		System.out.println("-----------------");
		
		fabrica = new FabricaBrasilia();
		
		Carro brasilia = fabrica.criarCarro();
		
		System.out.println("-----------------");
		System.out.println(brasilia.getMarca()); 
		System.out.println(brasilia.getModelo());
		System.out.println(brasilia.getAno()); 
		System.out.println(brasilia.getCor());
		System.out.println("-----------------");
	}

}
