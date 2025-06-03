import javax.swing.JOptionPane;

public class Exercicio_39
{
	public static void main(String[] args)
	{
		int aux,
			Numeros[] = new int[8];
		
		for(int i = 0; i < Numeros.length; i++)
			Numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um número inteiro: "));
		
		for(int j = 0; j < Numeros.length; j++)
		{
			for(int k = j+1; k < Numeros.length; k++)
			{
				if(Numeros[j] > Numeros[k])
				{
					aux = Numeros[k];
					Numeros[k] = Numeros[j];
					Numeros[j] = aux;
				}
			}
		}
		
		for(int l = 0; l < Numeros.length; l++)
			System.out.println(Numeros[l]);
	}
}