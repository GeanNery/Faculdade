package Exercicio_43;
import javax.swing.JOptionPane;

public class PESSOA
{
	private String nome, sexo;
	public String tipo;
	private double idade;
	
	public void Leitura()
	{
		nome = JOptionPane.showInputDialog(null, "Nome:", "Entrada", 3);
		idade = Double.parseDouble(JOptionPane.showInputDialog(null, "Idade:", "Entrada", 3));
				
		while(true)
		{
			sexo = JOptionPane.showInputDialog(null, "Sexo:", "Entrada", 3);
			
			if(sexo.toLowerCase().startsWith("m")) 
			{
				sexo = "MASCULINO";
				break;
			}
			else if(sexo.toLowerCase().startsWith("f")) 
			{
				sexo = "FEMININO";
				break;
			}
			else 
				JOptionPane.showMessageDialog(null, "Dígito inválido!\nTente novamente.", "Erro", 0);
		}
	}
	
	public void Mostrar()
	{
		JOptionPane.showMessageDialog(null,
		"["+tipo.toUpperCase()+"]\n" +
		"Nome:  " + nome.toUpperCase() + "\n" + 
		"Idade:  " + idade + "\n" + 
		"Sexo:  " + sexo,
		"Visualização", 1);
	}
}