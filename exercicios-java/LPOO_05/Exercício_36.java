import javax.swing.JOptionPane;

public class Exercício_36
{
	public static void main(String[] args) 
	{
		int numeros[] = new int[10],
			maior = 0,
			posicao = 0;
		
		for(int i = 0; i < 5; i++) 
		{
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um inteiro: "));
			
			if(i == 0) 
			{
				maior = numeros[i];
				posicao = i;
			}
			else if(numeros[i] > maior)
			{
				maior = numeros[i];
				posicao = i;
			}
		}
		
		JOptionPane.showMessageDialog(null, 
			"Maior valor:\n" + maior +
			"\nPosição no Array:\n" + posicao, 
			"RESULTADO", JOptionPane.INFORMATION_MESSAGE);
	}
}
