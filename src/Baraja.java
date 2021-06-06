import java.util.Random;                       // Ponemos la librería para la generación de números aleatorios
import pila.*;
public class Baraja {
	
	//ATRIBUTOS
	private Pila<Carta> pila_cartas;
	
	//CONSTRUCTOR
	public Baraja(){
		pila_cartas = new EnlazadaPila<Carta>();  //Creamos una pila de cartas
		int numero=1;                       //Inicializamos la variable numero a uno
		 int i;
	        //Creamos las cartas de oros
	        for(i=0; i<7; i++)
	        {
	            pila_cartas.push(new Carta (numero, "Oros"));
	            numero++;
	        }
	        pila_cartas.push(new Carta (10, "Oros"));
	        pila_cartas.push(new Carta (11, "Oros"));
	        pila_cartas.push(new Carta (12, "Oros"));
	        numero=1;
	      //Creamos las cartas de copas
	        for(i=0; i<7; i++)
	        {
	            pila_cartas.push(new Carta (numero, "Copas"));
	            numero++;
	        }
	        pila_cartas.push(new Carta (10, "Copas"));
	        pila_cartas.push(new Carta (11, "Copas"));
	        pila_cartas.push(new Carta (12, "Copas"));
	        numero=1;
	      //Creamos las cartas de espadas
	        for(i=0; i<7; i++)
	        {
	            pila_cartas.push(new Carta (numero, "Espadas"));
	            numero++;
	        }
	        pila_cartas.push(new Carta (10, "Espadas"));
	        pila_cartas.push(new Carta (11, "Espadas"));
	        pila_cartas.push(new Carta (12, "Espadas"));
	        numero=1;
	      //Creamos las cartas de bastos
	        for(i=0; i<7; i++)
	        {
	            pila_cartas.push(new Carta (numero, "Bastos"));
	            numero++;
	        }
	        pila_cartas.push(new Carta (10, "Bastos"));
	        pila_cartas.push(new Carta (11, "Bastos"));
	        pila_cartas.push(new Carta (12, "Bastos"));
	        
	        
	}
	
	//Creamos el método para mostrar la baraja
    
    public void mostrarBaraja()
  {
    	while (!pila_cartas.esVacio())
    		System.out.println(pila_cartas.pop());
  }
	//Barajar
	
    public void barajar(){
        Carta carta_aux;                //Definimos una variable auxiliar para almacenar el contenido de la carta que queremos cambiar
        int aleatorio_uno=0;           //Definimos las variables que van a almacenar los números que se van a generar aleatoriamente para
        int aleatorio_dos=0;           //Cambiarlos en el array
        int veces_barajar=0;            //Definimos una variable para contar las veces en que se baraja
        Carta [] array_cartas = new Carta [40];  //Creamos un array auxiliar para barajar las cartas
        int c=0;
        //Metemos todas las cartas de la pila en el array
        while(!pila_cartas.esVacio()){
        	array_cartas[c]=pila_cartas.pop();
        	c++;
        }
                      
        while(veces_barajar<=100){
            //Vamos a barajar las cartas tantas veces como querramos
        	Random rnd = new Random();             //Creamos el Random
            aleatorio_uno=rnd.nextInt(40);         //Las variables almacenan cada una el número alertorio que ha generado
            aleatorio_dos=rnd.nextInt(40);
       
	        //Una vez que tengamos los números aleatorios
	        carta_aux=array_cartas[aleatorio_uno]; //La auxiliar almacena el contenido del elemento 
	                                               //cuyo número fue generado por el primer aleatorio
	        array_cartas[aleatorio_uno]=array_cartas[aleatorio_dos]; //Recibe el contenido del elemento 
	                                                                //cuyo número fue generado por el segundo aleatorio
	        array_cartas[aleatorio_dos]=carta_aux;
	        veces_barajar++;                            //Incrementamos el contador de la baraja
        }
        for(int v=0; v < array_cartas.length; v++)
        	pila_cartas.push(array_cartas[v]);
        	
    }
	
    public Carta quitarCarta(){
    	System.out.println("Carta a entregar: "+ pila_cartas.top());
    	return pila_cartas.pop();
    }
    		
	/*public static void main(String[] args)
	{
		//Baraja b = new Baraja();
		// System.out.println(b.array_cartas[0].toString());
		
		b.barajar();
		b.mostrarBaraja();
	}	*/
	
	
}
