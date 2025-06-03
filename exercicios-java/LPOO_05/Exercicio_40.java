import javax.swing.JOptionPane;

public class Exercicio_40
{
	public static void main(String[] args)
	{
		String listaDeNomes[] = new String[5],
			   pesquisa = "";
		boolean cadastro;

		for(int i = 0; i < listaDeNomes.length; i++)
		{
			listaDeNomes[i] = JOptionPane.showInputDialog("Insira um nome: ");
			if(listaDeNomes[i].equals(""))
			{
				listaDeNomes = null;
				JOptionPane.showMessageDialog(null, "Entrada cancelada.", null, 0, null);
				break;
			}
		}
		
		if(listaDeNomes != null)
		{
			while(true)
			{
				cadastro = false;
				pesquisa = JOptionPane.showInputDialog("Pesquisar nome: ");
				if(pesquisa.equals("fim"))
					break;
				
				for(int j = 0; j < listaDeNomes.length; j++) 
				{
				    if ( listaDeNomes[j].equals(pesquisa))
				    {
				    	cadastro = true;
				    	break;
				    }
				}
				
				if(cadastro == true)
					JOptionPane.showMessageDialog(null, "O nome está cadastrado!", null, 1, null);
				else
					JOptionPane.showMessageDialog(null, "O nome NÃO ESTÁ cadastrado!", null, 0, null);
			}
		}
		
		System.exit(0);
	}
}