import javax.swing.JOptionPane;

public class Exercicio_38
{
	public static void main(String[] args)
	{
		double Num[] = new double[8],
			   Raiz[] = new double[Num.length];
		
		for(int i = 0; i < Num.length; i++)
		{
			Num[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira um número real: "));
			Raiz[i] = Math.sqrt(Num[i]);
		}
		
		for(int j = 0; j < Num.length; j++)
		{
			JOptionPane.showMessageDialog(null, "Número:   " + Num[j] + "\nRaiz:          " + Raiz[j], (j+1) + "/" + Num.length, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
