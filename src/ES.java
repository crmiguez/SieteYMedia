import java.util.Scanner;

public class ES {

		public static Scanner Leer = new Scanner(System.in);
		
		public static String pideCadena(String mensaje)
		{
				//Visualiza el mensaje
				System.out.print(mensaje);
				//Pide una cadena
				return Leer.nextLine();
		}
		
		
		public static int pideNumero(String mensaje)
		{
				//Visualiza el mensaje
				System.out.print(mensaje);
				//Pide un entero
				return Integer.parseInt(Leer.nextLine());
		}
}
