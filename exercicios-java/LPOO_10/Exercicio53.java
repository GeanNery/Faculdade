
public class Exercicio53 
{
	public static void main(String[] args)
	{
		int cont;
		double vetor[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20},
			   matriz[][] = new double[2][5];
		
		cont = vetor.length / 2;
		for(int lin = 0; lin < 2; lin++)
		{
			for(int col = 0; col < 5; col++)
			{
				// Instancia os elementos da matriz
				if(lin == 0)
					matriz[lin][col] = vetor[col] * 2;
				else
				{
					matriz[lin][col] = vetor[cont] / 2;
					cont++;
				}
				
				// Exibe a matriz
				if(col == (lin + 4))
					System.out.println(matriz[lin][col] + "\t");
				else
					System.out.print(matriz[lin][col] + "\t");
			}	
		}
	}
}