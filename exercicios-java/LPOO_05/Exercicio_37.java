import javax.swing.JOptionPane;

public class Exercicio_37
{
	public static void main(String[] args)
	{
		int i, numero,
			qtd_true = 0, 
			qtd_false = 0;
		boolean booleanos[] = new boolean[5];
		
		for(i = 0; i < booleanos.length; i++)
		{
			numero = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor 0 ou 1: "));
			
			if(numero == 0)
				booleanos[i] = false;
			else if(numero == 1)
				booleanos[i] = true;
			else
			{
				JOptionPane.showMessageDialog(null, "Número Inválido!\n\nDigite apenas 0 ou 1", null, JOptionPane.ERROR_MESSAGE);
				break;
			}
		}

		if(i >= booleanos.length)
		{
			for(int j = 0; j < booleanos.length; j++)
			{
				if(booleanos[j] == true)
					qtd_true++;
				else
					qtd_false++;
			}
			
			JOptionPane.showMessageDialog(null,"Quantidade de TRUES:     " + qtd_true + "\nQuantidade de FALSES:   " + qtd_false, null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
