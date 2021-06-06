
public class Maquina extends Jugador {
	public Maquina(String n, int d){
		super(n,d);
	}

	//Implementaci�n m�todo abstracto
	void jugar(Banca b){
		int pideApuesta=0;
		do{
			recibirCarta(b.entregarCarta());
			if(getApuesta()==0){
				//Le pedimos al usuario que apueste dado la primera carta
				do{
					pideApuesta=ES.pideNumero("�Cu�nto quieres apostar?: ");
				}while(pideApuesta <= 0 || pideApuesta > getDinero());
				setApuesta(pideApuesta);
				setRestarDinero(pideApuesta);
			}
		}while(puntuacionJugador()<=7.0);
		
	}

}
