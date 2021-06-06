
public class Carta {

	//ATRIBUTOS
	private int numero;
	private String palo;
	
	//CONSTRUCTOR
	public Carta (int num, String p)
	{
		numero=num;
		palo=p;
	}
	
	//OBSERVADORES
	public int getNumero ()

	{
		
		return numero;
		
	}
	
	public String getPalo ()

	{
		
		return palo;
		
	}
	
	//MÉTODO OBTENER VALOR DE LA CARTA
	public double getValor(){
		if (numero > 7) return 0.5;
		else return numero;
	}
	
	//toString()
	public String toString()
	{
		return "*" + numero + " de " + palo + "*";
	}
	
	
	
	
}
