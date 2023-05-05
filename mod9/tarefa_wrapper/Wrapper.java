import java.util.InputMismatchException;
import java.util.Scanner;

public class Wrapper {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numero;
	
		while (true) {

			try {
				System.out.print("Digite um numero inteiro: ");
				numero = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, certifique-se de digitar apenas valores numéricos.");
				sc.nextLine(); //isso é para remover o caracter \n no buffer
			}
		}
		
		Integer numeroWrapper = numero;
		
		System.out.println("valor do numero digitado em [Integer] = "+numeroWrapper);
		
		long tipoLong = numero;
		
		System.out.println("valor do numero digitado em [long] = "+tipoLong);
		
		Long tipoLongWrapper = tipoLong;
		
		System.out.println("valor do numero digitado em [Long] = "+tipoLongWrapper);
		
		numero = (int) tipoLong;
		
		System.out.println("valor do numero digitado após casting de long para int = "+numero);
		
		sc.close();

	}

}
