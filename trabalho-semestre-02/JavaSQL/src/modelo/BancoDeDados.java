package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import gui.Panel;

public class BancoDeDados
{
	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultSet;
	public static List<Ocorrencia> lista = new ArrayList<>();
	
	private static String SELECT_QUERY = "SELECT cidade.COD_MUNCP, CIDADE, DOENCA, doenca.COD_DOENCA, INFECTADOS, MORTOS, INTERNADOS, DATA FROM cidade INNER JOIN ocorrencia ON cidade.COD_MUNCP = ocorrencia.COD_MUNCP INNER JOIN doenca ON doenca.COD_DOENCA = ocorrencia.COD_DOENCA ORDER BY CIDADE, DOENCA, DATA";
	
	public static void conectar()
	{	
		try
		{
			String url = "jdbc:mysql://localhost:3306/pesquisa_doencas";
			String user = JOptionPane.showInputDialog("Usuário:");
			char[] password = Panel.pedirSenha();
			
			connection = DriverManager.getConnection(url, user, new String(password));
			Arrays.fill(password, ' ');
			statement = connection.createStatement();
			
			instanciarLista();
		}
		catch (NullPointerException exception) 
		{
			System.exit(0); // Sai do programa caso a senha não seja inserida
		}
		catch (SQLSyntaxErrorException exception) 
		{
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Banco de dados não foi encontrado.", "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		catch (SQLException exception)
		{	
			if(exception.getMessage().contains("Access denied"))
			{
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			exception.printStackTrace();
		}
	}
	
	// Resgata os dados que estão no BD e os insere na lista da JTable
	public static void instanciarLista() throws SQLException
	{
		lista.clear();
		resultSet = statement.executeQuery(SELECT_QUERY);
		
		while(resultSet.next())
		{
			Ocorrencia ocorrencia = new Ocorrencia();
			ocorrencia.codMuncp = resultSet.getInt(1);
			ocorrencia.nomeMuncp = resultSet.getString(2);
			ocorrencia.nomeDoenca = resultSet.getString(3);
			ocorrencia.codDoenca = resultSet.getString(4);
			ocorrencia.infectados = resultSet.getInt(5);
			ocorrencia.mortos = resultSet.getInt(6);
			ocorrencia.internados = resultSet.getInt(7);
			
			String dataOriginal = resultSet.getString(8),
				   dia = dataOriginal.substring(8, 10),
				   mes = dataOriginal.substring(5, 7),
				   ano = dataOriginal.substring(0, 4),
				   dataFormatada = dia+"/"+mes+"/"+ano;
			
			ocorrencia.data = dataFormatada;
			lista.add(ocorrencia);
		}
	}
	
	public static void editarElemento(String updateString) throws SQLException
	{
		statement.executeUpdate(updateString);
	}
	
	// Método responsável por inserir dados no BD
	public static void adicionarElemento(Ocorrencia ocorrencia) throws SQLException
	{
		boolean podeAdicionar = true;
		String dia = ocorrencia.data.substring(0, 2),
			   mes = ocorrencia.data.substring(2, 4),
			   ano = ocorrencia.data.substring(4, 6),
			   strCodMuncp = String.valueOf(ocorrencia.codMuncp);

		resultSet = statement.executeQuery("SELECT COD_MUNCP, CIDADE FROM cidade");
		podeAdicionar = verificar(resultSet, podeAdicionar, strCodMuncp, ocorrencia.nomeMuncp);
		if(podeAdicionar == true)
			statement.executeUpdate("INSERT INTO cidade VALUE ("+ocorrencia.codMuncp+", '"+ocorrencia.nomeMuncp+"')");
		
		resultSet = statement.executeQuery("SELECT COD_DOENCA, DOENCA FROM doenca");
		podeAdicionar = verificar(resultSet, podeAdicionar, ocorrencia.codDoenca, ocorrencia.nomeDoenca);
		if(podeAdicionar == true)
			statement.executeUpdate("INSERT INTO doenca VALUE ('"+ocorrencia.nomeDoenca+"', '"+ocorrencia.codDoenca+"')");
		
		statement.executeUpdate("INSERT INTO ocorrencia VALUE ('"+ocorrencia.codDoenca+"', "+ocorrencia.infectados+", "+ocorrencia.mortos+", "+ocorrencia.internados+", '"+ano+"-"+mes+"-"+dia+"', "+ocorrencia.codMuncp+")");
	}
	
	// Método responsável por remover dados do BD
	public static void removerElemento(Ocorrencia ocorrencia) throws SQLException
	{
		String dia = ocorrencia.data.substring(0, 2),
			   mes = ocorrencia.data.substring(3, 5),
			   ano = ocorrencia.data.substring(6, 10);

		statement.executeUpdate("DELETE FROM ocorrencia WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp);
	}
	
	// Antes de adicionar, verifica se a ocorrência já existe no BD
	public static boolean verificar(ResultSet resultSet, boolean podeAdicionar, String codigo, String nome) throws SQLException
	{
		podeAdicionar = true;	
		while(resultSet.next())
		{
			if(resultSet.getString(1).equals(codigo) || resultSet.getString(2).equals(nome))
			{
				podeAdicionar = false;
				break;
			}
		}
		return podeAdicionar;
	}
}