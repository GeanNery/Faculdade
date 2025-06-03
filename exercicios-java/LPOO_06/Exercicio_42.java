import javax.swing.JOptionPane;

public class Exercicio_42
{
	static double num, raiz;
	
	public static void main(String[] args)
	{
		while(true)
		{
			num = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira um número: ", "Entrada", 1));
			if(num == 0)
			{
				JOptionPane.showMessageDialog(null, "Fim de Execução.", "Aviso", 1, null);
				break;
			}
			
			JOptionPane.showMessageDialog(null, "Número:   " + num + "\n\nRaiz:   " + RaizQuadr(), "Resultado", 1, null);
		}
		
		System.exit(0);
	}
	
	public static double RaizQuadr()
	{
		raiz = Math.sqrt(num);
		return raiz;
	}
}