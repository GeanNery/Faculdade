package Exercicio_43;
import javax.swing.JOptionPane;

public class ATOR_FIGURANTE
{
	public static void main(String[] args)
	{
		PESSOA pessoa = new PESSOA();
		
		while(true)
		{
			pessoa.tipo = JOptionPane.showInputDialog(null, "Insira o seu papel: ", "Entrada", 3);
			if(pessoa.tipo.equals("fim"))
			{
				JOptionPane.showMessageDialog(null, "Fim de execução.", "Aviso", 2);
				break;
			}
			pessoa.Leitura();
			pessoa.Mostrar();
		}

		System.exit(0);
	}
}
