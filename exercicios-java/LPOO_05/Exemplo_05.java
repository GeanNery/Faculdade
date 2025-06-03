// UTILIZAÇÃO DE ARRAYS

public class Exemplo_05
{
	public static void main(String[] args) 
	{
		double ale[] = new double[50];
		
		for(int i = 0; i < ale.length; i++)
			ale[i] = 100.0 * Math.random();
		
		for(int j = 0; j < ale.length; j++)
			System.out.printf("%d\t%d%n", j, (int)(ale[j]));
	}
}