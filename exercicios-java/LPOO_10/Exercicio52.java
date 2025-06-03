
public class Exercicio52 
{
	public static void main(String[] args)
	{
		int matriz[][] = new int[5][5];
		
		for(int lin = 0; lin < 5; lin++)
		{
			for(int col = 0; col < 5; col++)
			{
				if(lin == col)
					matriz[lin][col] = 1;
				else
					matriz[lin][col] = 0;

				if(col == 0 && lin > 0)
					System.out.print("\n" + matriz[lin][col]);
				else
					System.out.print(matriz[lin][col]);
			}
		}
	}
}