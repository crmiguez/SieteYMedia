
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
		cartasManoBanca= new Carta[15]; /*Inicializamos el array de la mano de cartas de la banca a un n�mero m�ximo
										en este caso de 15 cartas*/
	}
	//M�TODO BARAJAR POR LA BANCA
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
				
	//M�TODO ENTREGAR CARTA AL JUGADOR
	public Carta entregarCarta(){
		return bar.quitarCarta();
	}
	
	//M�TODO RECIBIR CARTA POR PARTE DE LA BANCA
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
							"\n N�mero de cartas: " + nCartasBanca + "\n Cartas: " + cartasBanca;
					
				}
	
	//M�TODO PUNTUACI�N BANCA
		public double puntuacionBanca(){
				double sumaTotal=0.0;
				for (int p=0; p < nCartasBanca; p++)
					sumaTotal+=cartasManoBanca[p].getValor();
				return sumaTotal;	
		}
	//M�TODO COBRO APUESTAS
		public void cobroApuestas(Jugador[] jugs){
			for (int r=0; r<=jugs.length-1; r++)
				//Mostramos puntuaciones
				//Si hay empate o gan� la Banca
				if ( jugs[r].puntuacionJugador() == puntuacionBanca() || jugs[r].puntuacionJugador()>7.5 ){
					System.out.println (jugs[r].getNombre()+" pierde. Puntuaci�n:"+jugs[r].puntuacionJugador()+". ");
					System.out.println(" ��GANA LA BANCA!!! Puntuaci�n de la Banca: "+puntuacionBanca()+ "");
				//Se le suma toda la apuesta de cada jugador a la Banca
				setSumarDinero(jugs[r].getApuesta());
				}
			//Sino
				else {
					if (jugs[r].puntuacionJugador()<=7.5 && puntuacionBanca()>7.5){
				//Si el jugador alcanz� las 7 y media y la banca las super�
				if (jugs[r].puntuacionJugador()==7.5){
					//Cobra el doble de lo apostado
					System.out.println (jugs[r].getNombre()+" tiene las siete y media. ��GAN� A LA BANCA!!. Cobra "+jugs[r].getApuesta()*3+" � ");
					jugs[r].setSumarDinero(jugs[r].getApuesta()*2);
					setRestarDinero(jugs[r].getApuesta()*2);
					}
				else
					//Sino, cobra la apuesta que hizo al principio
					System.out.println (jugs[r].getNombre()+" . Puntuaci�n: "+jugs[r].puntuacionJugador()+" . Gana lo apostado: "+jugs[r].getApuesta()+" � ");
					jugs[r].setSumarDinero(jugs[r].getApuesta());
					setRestarDinero(jugs[r].getApuesta());
					}
					else {
						
					//Si el jugador alcanz� las 7 y media y la banca no
					if (jugs[r].puntuacionJugador()==7.5){
						//Cobra el doble de lo apostado
						System.out.println (jugs[r].getNombre()+" tiene las siete y media. ��GAN� A LA BANCA!!. Cobra "+jugs[r].getApuesta()*3+" � ");
						jugs[r].setSumarDinero(jugs[r].getApuesta()*2);
						setRestarDinero(jugs[r].getApuesta()*2);
						}
					else
						//Sino, cobra la apuesta que hizo al principio
						System.out.println (jugs[r].getNombre()+" . Puntuaci�n: "+jugs[r].puntuacionJugador()+" . Gana lo apostado: "+jugs[r].getApuesta()+" � ");
						jugs[r].setSumarDinero(jugs[r].getApuesta());
						setRestarDinero(jugs[r].getApuesta());
				}
			}
		}
}
