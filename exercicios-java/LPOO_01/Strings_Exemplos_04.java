public class Strings_Exemplos_04
{
	public static void main(String[] args)
	{
		String textoExemplo = "  Java  ";
		
		System.out.println("***" + textoExemplo + "***"); 	   	 // será impresso "***  Java  ***"
		
		System.out.println("***" + textoExemplo.trim() + "***"); // será impresso "***Java***"
	}
}
