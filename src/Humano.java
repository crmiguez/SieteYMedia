
public class Humano extends Jugador{
	public Humano(String n, int d){
		super(n,d);
	}
	//Implementación método abstracto Humano
	void jugar(Banca b){
				int pideApuesta=0;
				String respuestaJugador="SI";	//Declaramos una variable de respuesta para plantarse
				//Mientras que el jugador quiera más cartas se repite
				while(respuestaJugador.equals("SI") || respuestaJugador.equals("si")){
					recibirCarta(b.entregarCarta());
					//Si no ha apostado
					if(getApuesta()==0){
						//Le pedimos al usuario que apueste dado la primera carta
						do{
							pideApuesta=ES.pideNumero("¿Cuánto quieres apostar?: ");
						}while(pideApuesta <= 0 || pideApuesta > getDinero());
						setApuesta(pideApuesta);
						setRestarDinero(pideApuesta);
					}
					respuestaJugador = ES.pideCadena("¿Quieres una carta (SI/NO)?: ");
				}
	}

}
