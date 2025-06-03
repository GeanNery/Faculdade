package gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import modelo.BancoDeDados;
import modelo.Municipios_SaoPaulo;
import modelo.Ocorrencia;
import modelo.TableModel;

public class Panel extends JPanel implements ActionListener
{
	private static JTable tabela;
	private static TableModel modeloTabela;
	private JButton adicionar = new JButton("Adicionar"), remover = new JButton("Remover");
	private Ocorrencia ocorrencia;
	
	public static char[] pedirSenha()
	{
		JPasswordField passwordField = new JPasswordField();
		int opcao = JOptionPane.showConfirmDialog(null, passwordField, "Senha:", JOptionPane.OK_CANCEL_OPTION);
		
		if (opcao == JOptionPane.OK_OPTION) 
		{
			char[] senha = passwordField.getPassword();
			return senha;
		}
		return null;
	}
	
	public Panel()
	{
		setLayout(null);
		setSize(Frame.sizeX, Frame.sizeY);
		
		// TABELA
		JPanel painel_01 = new JPanel();
			painel_01.setSize(1000, 600);
			painel_01.setLocation(540 - 500, 425 - 340);
			painel_01.setLayout(new BorderLayout());
			modeloTabela = new TableModel(BancoDeDados.lista);
			tabela = new JTable(modeloTabela);
			tabela.setRowSelectionAllowed(true);
			tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane scrollPane = new JScrollPane(tabela);
			painel_01.add(scrollPane, BorderLayout.CENTER);
		
			tabela.addMouseListener(new MouseAdapter() 
			{
			    @Override
			    public void mouseClicked(MouseEvent mouseEvent) 
			    {
			        int row = tabela.rowAtPoint(mouseEvent.getPoint());
			        int col = tabela.columnAtPoint(mouseEvent.getPoint());
			        if (row >= 0 && col >= 0) 
			        {
			            tabela.setRowSelectionInterval(row, row); // Seleciona a linha
			            if (mouseEvent.getClickCount() == 2 && tabela.isCellEditable(row, col))
			            {
			                tabela.editCellAt(row, col);
			                tabela.requestFocusInWindow();
			            }
			        }
			    }
			});
			
		// BOTÕES
		JPanel painel_02 = new JPanel();
			painel_02.setSize(193, 26);
			painel_02.setLocation(850, 700);
			painel_02.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,0));
			adicionar.addActionListener(this);
			remover.addActionListener(this);
			painel_02.add(adicionar);
			painel_02.add(remover);
		
		add(painel_01);
		add(painel_02);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		try
		{
			if(actionEvent.getSource() == adicionar)			
				botaoAdicionar();
			
			if(actionEvent.getSource() == remover)
				botaoRemover();
		}
		catch (NullPointerException exception)
		{
			return; // Fecha a janela de diálogo em caso de erro
		}
		catch (SQLException exception) 
		{
			exception.printStackTrace();
		}
	}
	
	private void leituraTexto()
	{
		while(true)
		{
			ocorrencia.nomeMuncp = JOptionPane.showInputDialog("Nome do município: ").toUpperCase();
			
			if(Municipios_SaoPaulo.municipios.containsKey(ocorrencia.nomeMuncp))
				break;		
			JOptionPane.showMessageDialog(null, "O município informado não existe ou foi inserido incorretamente.\n\nTente novamente.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
		}
		ocorrencia.codMuncp = Municipios_SaoPaulo.municipios.get(ocorrencia.nomeMuncp);
		ocorrencia.nomeDoenca = JOptionPane.showInputDialog("Nome da doença: ").toUpperCase();
		ocorrencia.codDoenca = JOptionPane.showInputDialog("Código da doença: ").toUpperCase();
	}
	
	private void leituraNumero()
	{
		ocorrencia.infectados = Integer.parseInt(JOptionPane.showInputDialog("Nº de infectados: "));
		ocorrencia.mortos = Integer.parseInt(JOptionPane.showInputDialog("Nº de mortos: "));
		ocorrencia.internados = Integer.parseInt(JOptionPane.showInputDialog("Nº de internados: "));
	}
	
	private void leituraData()
	{
		while(true)
		{
			ocorrencia.data = JOptionPane.showInputDialog("Data [DDMMAA]: ");
			
			if(ocorrencia.data.length() == 6)
				break;
			JOptionPane.showMessageDialog(null, "Data inválida!\nA data deve conter 6 (seis) dígitos, no formato: DDMMAA\n\nTente novamente.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void atualizarTabela() throws SQLException
	{
		BancoDeDados.instanciarLista();
		modeloTabela = new TableModel(BancoDeDados.lista);
		tabela.setModel(modeloTabela);
	}
	
	private void botaoAdicionar() throws SQLException
	{
		ocorrencia = new Ocorrencia();
		leituraTexto();
		try
		{
			leituraNumero();
		}
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null, "Insira apenas números inteiros!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
			return;
		}
		leituraData();
		
		try
		{
			BancoDeDados.adicionarElemento(ocorrencia);
			atualizarTabela();
		}
		catch (SQLIntegrityConstraintViolationException exception) 
		{
			JOptionPane.showMessageDialog(null, "Já existe um registro semelhante nessa mesma data.\n\nNão é permitida a repetição de ocorrências!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
		}
		catch (MysqlDataTruncation exception) 
		{
			JOptionPane.showMessageDialog(null, "Dados inválidos!  Verifique a integridade das informações.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void botaoRemover() throws SQLException
	{
		int selectedRows[] = tabela.getSelectedRows();
		
		if(selectedRows.length != 0)
		{
			char[] senha = pedirSenha();
			char[] senhaCorreta = new char[] {'m','y','s','q','l'};
			
			if(Arrays.equals(senha, senhaCorreta))
			{
				Arrays.fill(senha, ' ');
				Arrays.fill(senhaCorreta, ' ');
				
				for(int i = 0; i < selectedRows.length; i++)
				{
					Ocorrencia ocorrenciaSelecionada = BancoDeDados.lista.get(selectedRows[i]);
					BancoDeDados.removerElemento(ocorrenciaSelecionada);
				}
				atualizarTabela();
			}
			else if(senha != null && !Arrays.equals(senha, senhaCorreta))
			{
				JOptionPane.showMessageDialog(null, "Senha incorreta!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			Arrays.fill(senha, ' ');
			Arrays.fill(senhaCorreta, ' ');
		}
	}
}