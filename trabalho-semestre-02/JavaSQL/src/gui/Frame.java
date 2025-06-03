package gui;
import javax.swing.JFrame;
import modelo.BancoDeDados;
import modelo.Municipios_SaoPaulo;

public class Frame extends JFrame
{	
	public static int sizeX = 1100, sizeY = 810;
	
	public Frame()
	{
		setTitle("APS 2º SEMESTRE");
		setSize(sizeX, sizeY);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		Panel painel = new Panel();
		add(painel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		BancoDeDados.conectar();
		Municipios_SaoPaulo.instanciarLista();
		Frame janela = new Frame();
	}
}