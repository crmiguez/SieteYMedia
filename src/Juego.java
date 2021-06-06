
public class Juego {
	public static void main (String[] args){
		//Pedir número de jugadores por teclado
		int numJugadores;
		do{
			numJugadores=ES.pideNumero("Introduce el número de jugadores: ");
		} while (numJugadores< 2 || numJugadores > 8);
		

		//Crear jugadores
		Jugador [] array_jugadores=new Jugador [numJugadores];
		String nombre;
		int pideDinero;
		String tipoJugador="";
		for (int j=0; j < numJugadores; j++){
			nombre=ES.pideCadena("Introduce el nombre del jugador "+ (j+1) + ": ");
			do{
				pideDinero=ES.pideNumero("¿Con cuánto dinero vas a empezar? [Máximo de 500€]: ");
			}while(pideDinero <= 0 || pideDinero > 500);
			
			do{
				tipoJugador= ES.pideCadena("¿De qué tipo es el jugador "+ (j+1) + " [Maquina/Humano]: ");
			}while(!tipoJugador.equalsIgnoreCase("Maquina") && !tipoJugador.equalsIgnoreCase("Humano"));
			if(tipoJugador.equalsIgnoreCase("Humano"))
				array_jugadores[j]=new Humano(nombre, pideDinero);
			else if (tipoJugador.equalsIgnoreCase("Maquina"))
				array_jugadores[j]=new Maquina(nombre, pideDinero);
		}
		//Visualizar jugadores
		 for(int k=0; k < numJugadores; k++)
	          System.out.println (array_jugadores[k].toString());
	
		//Pedimos el nombre de la Banca
		 String nomBanca;
		 Banca jugadorBanca;
		 int pideDineroBanca;
		 nomBanca=ES.pideCadena("Introduce el nombre de la Banca: ");
		 do{
				pideDineroBanca=ES.pideNumero("¿Con cuánto de dinero vas a empezar? [Mínimo de 5.000€ y máximo de 10.000€]: ");
			}while(pideDineroBanca < 5000 || pideDineroBanca > 10000);
		 jugadorBanca=new Banca (nomBanca,pideDineroBanca);
		 //Visualizar banca
		 System.out.println (jugadorBanca.toString());

		//Se barajan las cartas en Banca
		jugadorBanca.barajarBanca();
		
		
		//Recorremos el vector para el turno de los jugadores y preguntamos al jugador si quiere otra carta
		for (int t=0; t<= array_jugadores.length-1; t++){
				System.out.println ("Turno de " + array_jugadores[t].getNombre() + " ");
				array_jugadores[t].jugar(jugadorBanca);
		}
		//Turno de la Banca para jugar
		String respuesta="SI";		//Declaramos una variable de respuesta para plantarse
		System.out.println ("Turno de la Banca: " +jugadorBanca.getNombre()+" ");
		while(respuesta.equals("SI") || respuesta.equals("si")){
			jugadorBanca.recibirCarta(jugadorBanca.entregarCarta());
			respuesta = ES.pideCadena("¿Quieres una carta (SI/NO)?: ");
		}
		
		//Comprobamos la información de cada uno de los jugadores
		for(int k=0; k < numJugadores; k++)
	          System.out.println (array_jugadores[k].toString());
		//Comprobamos la información de la Banca
		 System.out.println (jugadorBanca.toString());
		//Llamamos al método cobrarApuestas de la Banca para mostrar el resultado del juego 
		jugadorBanca.cobroApuestas(array_jugadores);
		
		//Comprobamos los saldos finales de cada uno de los jugadores
		for(int k=0; k < numJugadores; k++)
			 System.out.println (array_jugadores[k].toString());
		//Comprobamos el saldo final de la banca
		 System.out.println (jugadorBanca.toString());
		//Mostramos por pantalla de que se acabó el juego
		System.out.println ("***FIN DEL JUEGO SIETE Y MEDIA***");
	}
	
}
