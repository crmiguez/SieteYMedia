
public class Banca {
	//ATRIBUTOS
	private String nombre;
	private int dineroBanca;
	private Carta [] cartasManoBanca;
	private int nCartasBanca;
	private Baraja bar;
	
	//CONSTRUCTOR
	public Banca (String nom, int d){
		nombre=nom;
		dineroBanca=d;
		nCartasBanca=0;
		bar=new Baraja();
		cartasManoBanca= new Carta[15]; /*Inicializamos el array de la mano de cartas de la banca a un número máximo
										en este caso de 15 cartas*/
	}
	//MÉTODO BARAJAR POR LA BANCA
	public void barajarBanca(){
		bar.barajar();
	}
	//OBSERVADORES
		public String getNombre ()
	
		{
			
			return nombre;
			
		}
		public int getDinero ()

		{
			
			return dineroBanca;
			
		}
	//MODIFICADORES
		
		public void setDinero (int din)

		{
			
			dineroBanca=din;
			
		}
	
	//MODIFICADORES (SUMAR DINERO)
		public int setSumarDinero (int sum)
			{
					
				return dineroBanca+=sum;
					
			}
		
		//MODIFICADORES (RESTAR DINERO)
				public int setRestarDinero (int res)
					{
							
						return dineroBanca-=res;
							
					}
				
	//MÉTODO ENTREGAR CARTA AL JUGADOR
	public Carta entregarCarta(){
		return bar.quitarCarta();
	}
	
	//MÉTODO RECIBIR CARTA POR PARTE DE LA BANCA
		public void recibirCarta (Carta c){
			
			cartasManoBanca[nCartasBanca++] = c;
			
		}
		
		//toString()
				public String toString()
				{
					String cartasBanca="";
					
					for (int i=0; i<nCartasBanca; i++)
					{
						cartasBanca+=cartasManoBanca[i].toString();
					}
					return "Nombre: " + nombre + "\n Dinero: " + dineroBanca +
							"\n Número de cartas: " + nCartasBanca + "\n Cartas: " + cartasBanca;
					
				}
	
	//MÉTODO PUNTUACIÓN BANCA
		public double puntuacionBanca(){
				double sumaTotal=0.0;
				for (int p=0; p < nCartasBanca; p++)
					sumaTotal+=cartasManoBanca[p].getValor();
				return sumaTotal;	
		}
	//MÉTODO COBRO APUESTAS
		public void cobroApuestas(Jugador[] jugs){
			for (int r=0; r<=jugs.length-1; r++)
				//Mostramos puntuaciones
				//Si hay empate o ganó la Banca
				if ( jugs[r].puntuacionJugador() == puntuacionBanca() || jugs[r].puntuacionJugador()>7.5 ){
					System.out.println (jugs[r].getNombre()+" pierde. Puntuación:"+jugs[r].puntuacionJugador()+". ");
					System.out.println(" ¡¡GANA LA BANCA!!! Puntuación de la Banca: "+puntuacionBanca()+ "");
				//Se le suma toda la apuesta de cada jugador a la Banca
				setSumarDinero(jugs[r].getApuesta());
				}
			//Sino
				else {
					if (jugs[r].puntuacionJugador()<=7.5 && puntuacionBanca()>7.5){
				//Si el jugador alcanzó las 7 y media y la banca las superó
				if (jugs[r].puntuacionJugador()==7.5){
					//Cobra el doble de lo apostado
					System.out.println (jugs[r].getNombre()+" tiene las siete y media. ¡¡GANÓ A LA BANCA!!. Cobra "+jugs[r].getApuesta()*3+" € ");
					jugs[r].setSumarDinero(jugs[r].getApuesta()*2);
					setRestarDinero(jugs[r].getApuesta()*2);
					}
				else
					//Sino, cobra la apuesta que hizo al principio
					System.out.println (jugs[r].getNombre()+" . Puntuación: "+jugs[r].puntuacionJugador()+" . Gana lo apostado: "+jugs[r].getApuesta()+" € ");
					jugs[r].setSumarDinero(jugs[r].getApuesta());
					setRestarDinero(jugs[r].getApuesta());
					}
					else {
						
					//Si el jugador alcanzó las 7 y media y la banca no
					if (jugs[r].puntuacionJugador()==7.5){
						//Cobra el doble de lo apostado
						System.out.println (jugs[r].getNombre()+" tiene las siete y media. ¡¡GANÓ A LA BANCA!!. Cobra "+jugs[r].getApuesta()*3+" € ");
						jugs[r].setSumarDinero(jugs[r].getApuesta()*2);
						setRestarDinero(jugs[r].getApuesta()*2);
						}
					else
						//Sino, cobra la apuesta que hizo al principio
						System.out.println (jugs[r].getNombre()+" . Puntuación: "+jugs[r].puntuacionJugador()+" . Gana lo apostado: "+jugs[r].getApuesta()+" € ");
						jugs[r].setSumarDinero(jugs[r].getApuesta());
						setRestarDinero(jugs[r].getApuesta());
				}
			}
		}
}
