
abstract class Jugador {
		//ATRIBUTOS
		private String nombre;
		private int dinero;
		private int apuesta;
		private Carta [] cartasMano;
		private int nCartas;
		
		//CONSTRUCTOR
		public Jugador(String n, int d){
			nombre=n;
			dinero=d;
			apuesta=0;
			nCartas=0;
			cartasMano= new Carta [15]; /*Inicializamos el array de la mano de cartas del jugador a un número máximo
			 							en este caso de 15 cartas*/
		}
		//OBSERVADORES
		public String getNombre ()
	
		{
			
			return nombre;
			
		}
		
		public int getDinero ()
	
		{
			
			return dinero;
			
		}
		
		public int getApuesta ()
	
		{
			
			return apuesta;
			
		}
		
		//MODIFICADORES
		public void setNombre (String nom)
	
		{
			
			nombre=nom;
			
		}
		
		public void setDinero (int din)
	
		{
			
			dinero=din;
			
		}
		
		public void setApuesta (int ap)
	
		{
			
			apuesta=ap;
			
		}
		
		//MODIFICADORES (SUMAR/RESTAR DINERO)
		public int setSumarDinero (int sum)
	
		{
			
			return dinero+=sum;
			
		}
		
		public int setRestarDinero (int rest)
	
		{
			
			return dinero-=rest;
			
		}
		
		//MÉTODO RECIBIR CARTA
		public void recibirCarta (Carta c){
			
			cartasMano[nCartas++] = c;
			
		}
	
	//toString()
		public String toString()
		{
			String cartas="";
			
			for (int i=0; i<nCartas; i++)
			{
				cartas+=cartasMano[i].toString();
			}
			return "Nombre: " + nombre + "\n Dinero: " + dinero +
					"\n Apuesta:" + apuesta +"\n Número de cartas: " + nCartas + "\n Cartas: " + cartas;
			
		}
		
	//	MÉTODO PUNTUACIÓN JUGADOR
		public double puntuacionJugador(){
			double sumaTotal=0.0;
			for (int p=0; p < nCartas; p++)
				sumaTotal+=cartasMano[p].getValor();
			return sumaTotal;	
		}
		
		abstract void jugar(Banca b);
}
