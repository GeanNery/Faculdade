// ATRIBUIÇÃO DE VALORES

public class Exemplo_02
{
	public static void main(String[] args) 
	{
		int numero[] = new int[100];
		
		numero[0] = 13;
		numero[18] = 47;
		numero[99] = 23;
		
		// EXIBIÇÃO:
		
		for(int i = 0; i < numero.length; i++) 
			System.out.printf("%d\t%d%n", i, numero[i]);
	}
}
