public class Strings_Exemplo_01
{
	public static void main(String[] args) 
	{
		String textoExemplo = "Linguagem Java";
		
		System.out.println(textoExemplo);
			
		System.out.println(textoExemplo.substring(2)); 	 // será impresso "nguagem Java"
			
		System.out.println(textoExemplo.substring(2,8)); // será impresso "nguage"	
	}
}
