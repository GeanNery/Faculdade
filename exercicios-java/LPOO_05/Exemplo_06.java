// UTILIZAÇÃO DE ARRAYS
import javax.swing.JOptionPane;

public class Exemplo_06
{
	public static void main(String[] args) 
	{
		int Numeros[] = new int[10],
			i, j, aux;
		
		for(i = 0; i < 10; i++) 
		{
			Numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um inteiro: "));
		}
		
		// CLASSIFICAÇÃO DE ARRAY
		for(i = 0; i < 10; i++) 
		{
			for(j = i + 1; j < 10; j++) // j é igual a i mais um.
			{
				if(Numeros[i] > Numeros[j])  // se i for maior do que j...
				{
					aux = Numeros[i]; 			// variável auxiliar salva o valor de i para uso posterior
					Numeros[i] = Numeros[j];	// o valor de j passa para i
					Numeros[j] = aux;			// j recupera o valor de i através da auxiliar. 
				}
			}
		}
		
		for(int k = 0; k < 10; k++)
			System.out.println(Numeros[k]);
	}
}
