package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import gui.Panel;

public class TableModel extends AbstractTableModel
{
	public List<Ocorrencia> lista;
	
	private final int COD_MUNCP = 0,
					  NOME_MUNCP = 1,
					  NOME_DOENCA = 2,
					  COD_DOENCA = 3,
					  NUM_INFECTADOS = 4,
					  NUM_MORTOS = 5,
					  NUM_INTERNADOS = 6,
					  DATA = 7;
					  
	public TableModel(List<Ocorrencia> ocorrencias)
	{
		this.lista = ocorrencias;
	}

	@Override
	public int getRowCount()
	{
		return this.lista.size();
	}

	@Override
	public int getColumnCount()
	{
		return 8;
	}
	
	@Override
	public String getColumnName(int column)
	{
		switch (column)
		{
			case COD_MUNCP:
				return "Cód. município";
			case NOME_MUNCP:
				return "Município";
			case NOME_DOENCA:
				return "Doença";
			case COD_DOENCA:
				return "Cód. Doença";
			case NUM_INFECTADOS:
				return "Nº Infectados";
			case NUM_MORTOS:
				return "Nº Mortos";
			case NUM_INTERNADOS:
				return "Nº Internados";
			case DATA:
				return "Data de registro";
			default:
				break;
		}
		return "";
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex)
	{
		Ocorrencia ocorrencia = lista.get(rowIndex);
		
		String updateOcorrencia = "UPDATE ocorrencia SET ",
			   updateDoenca = "UPDATE doenca SET ",
			   executeUpdate,
			   dia = ocorrencia.data.substring(0, 2),
			   mes = ocorrencia.data.substring(3, 5),
			   ano = ocorrencia.data.substring(6, 10);
	    
	    switch (columnIndex) 
	    {
	        case 0: // IGNORA ALTERAÇÕES NO CÓD. DO MUNICÍPIO
	        	break;
	        case 1: // EDITA O NOME DO MUNICÍPIO
	        	String newNomeMuncp = value.toString().toUpperCase();
	        	
	        	if(Municipios_SaoPaulo.municipios.containsKey(newNomeMuncp))
	        	{
	        		String codigo = String.valueOf(Municipios_SaoPaulo.municipios.get(newNomeMuncp));
	        		
	        		try
					{
	        			Statement statement = BancoDeDados.statement;
	        			ResultSet resultSet = BancoDeDados.resultSet;
		        		resultSet = statement.executeQuery("SELECT COD_MUNCP, CIDADE FROM CIDADE");
		        		
		        		boolean podeAdicionar = true;
		        		podeAdicionar = BancoDeDados.verificar(resultSet, podeAdicionar, codigo, newNomeMuncp);
		        		
		        		if(podeAdicionar == true)
		        		{
		        			BancoDeDados.editarElemento("INSERT INTO CIDADE VALUE ("+Municipios_SaoPaulo.municipios.get(newNomeMuncp)+", '"+newNomeMuncp+"')");
		        		}
		        		int codMuncp = Municipios_SaoPaulo.municipios.get(newNomeMuncp);
		        		executeUpdate = updateOcorrencia + "COD_MUNCP="+codMuncp+" WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp+"";
						
		        		BancoDeDados.editarElemento(executeUpdate);
						Panel.atualizarTabela();
					}
	        		catch (SQLIntegrityConstraintViolationException exception) 
		        	{
		        		JOptionPane.showMessageDialog(null, "Já existe um registro semelhante nessa mesma data.\n\nNão é permitida a repetição de ocorrências!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
					}
	        		catch (SQLException exception)
					{
						exception.printStackTrace();
					}
	        	}
	        	else 
	        	{
	        		JOptionPane.showMessageDialog(null, "O município informado não existe ou foi inserido incorretamente.\n\nTente novamente.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
				}
	        	break;
	        case 2: // EDITA O NOME DA DOENÇA
				try
				{
					String newNomeDoenca = value.toString().toUpperCase();
		        	executeUpdate = updateDoenca + "DOENCA='"+newNomeDoenca+"' WHERE DOENCA='"+ocorrencia.nomeDoenca+"' AND COD_DOENCA='"+ocorrencia.codDoenca+"'";
		        	
					BancoDeDados.editarElemento(executeUpdate);
					Panel.atualizarTabela();
				} 
				catch (SQLException exception)
				{
					exception.printStackTrace();
				}
	        	break;
	        case 3: // EDITA O CÓDIGO DA DOENÇA
				try
				{
					String newCodDoenca = value.toString().toUpperCase();
					
		        	executeUpdate = updateDoenca + "COD_DOENCA='"+newCodDoenca+"' WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND DOENCA='"+ocorrencia.nomeDoenca+"'";
		        	BancoDeDados.editarElemento(executeUpdate);
		        	
		        	executeUpdate = updateOcorrencia + "COD_DOENCA='"+newCodDoenca+"' WHERE COD_DOENCA='"+ocorrencia.codDoenca+"'";
					BancoDeDados.editarElemento(executeUpdate);
					
					Panel.atualizarTabela();
				}
				catch (SQLIntegrityConstraintViolationException exception) 
				{
					JOptionPane.showMessageDialog(null, "Já existe um registro com este código!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
				}
				catch (SQLException exception)
				{
					exception.printStackTrace();
				}
	        	break;
	        case 4: // EDITA O Nº DE INFECTADOS
				try
				{
					int newInfectados = Integer.parseInt(value.toString());
		        	executeUpdate = updateOcorrencia + "INFECTADOS="+newInfectados+" WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp+"";
					
		        	BancoDeDados.editarElemento(executeUpdate);
					Panel.atualizarTabela();
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Você tentou inserir um número não inteiro\nou talvez o valor seja muito elevado.\n\nTente inserir outro valor.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
				}
				catch (MysqlDataTruncation exception) 
				{
					JOptionPane.showMessageDialog(null, "Dígito inválido!  Insira apenas números inteiros positivos.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException exception)
				{
					exception.printStackTrace();
				}
	        	break;
	        case 5: // EDITA O Nº DE MORTOS
				try
				{
					int newMortos = Integer.parseInt(value.toString());
		        	executeUpdate = updateOcorrencia + "MORTOS="+newMortos+" WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp+"";
					
		        	BancoDeDados.editarElemento(executeUpdate);
					Panel.atualizarTabela();
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Você tentou inserir um número não inteiro\nou talvez o valor seja muito elevado.\n\nTente inserir outro valor.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
				}
				catch (MysqlDataTruncation exception) 
				{
					JOptionPane.showMessageDialog(null, "Dígito inválido!  Insira apenas números inteiros positivos.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException exception)
				{
					exception.printStackTrace();
				}
	        	break;
	        case 6: // EDITA O Nº DE INTERNADOS
				try
				{
					int newInternados = Integer.parseInt(value.toString());
		        	executeUpdate = updateOcorrencia + "INTERNADOS="+newInternados+" WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp+"";
					
		        	BancoDeDados.editarElemento(executeUpdate);
					Panel.atualizarTabela();
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Você tentou inserir um número não inteiro\nou talvez o valor seja muito elevado.\n\nTente inserir outro valor.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
				}
				catch (MysqlDataTruncation exception) 
				{
					JOptionPane.showMessageDialog(null, "Dígito inválido!  Insira apenas números inteiros positivos.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException exception)
				{
					exception.printStackTrace();
				}
	        	break;
	        case 7: // EDITA A DATA DE REGISTRO
	        	try
				{
	        		String newData = value.toString(),
	 	        		   newDia = newData.substring(0, 2),
	 	     			   newMes = newData.substring(3, 5),
	 	     			   newAno = newData.substring(6, 10);
	        		executeUpdate = updateOcorrencia + "DATA='"+newAno+"-"+newMes+"-"+newDia+"' WHERE COD_DOENCA='"+ocorrencia.codDoenca+"' AND INFECTADOS="+ocorrencia.infectados+" AND MORTOS="+ocorrencia.mortos+" AND INTERNADOS="+ocorrencia.internados+" AND DATA='"+ano+"-"+mes+"-"+dia+"' AND COD_MUNCP="+ocorrencia.codMuncp+"";
	        		
	        		BancoDeDados.editarElemento(executeUpdate);
	        		Panel.atualizarTabela();
				}
	        	catch (SQLIntegrityConstraintViolationException exception) 
	        	{
	        		JOptionPane.showMessageDialog(null, "Já existe um registro semelhante nessa mesma data.\n\nNão é permitida a repetição de ocorrências!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
				}
	        	catch (MysqlDataTruncation exception) 
	    		{
	    			JOptionPane.showMessageDialog(null, "Dados inválidos!  Verifique a integridade das informações.", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
	    		}
	        	catch (StringIndexOutOfBoundsException exception) 
	        	{
	        		JOptionPane.showMessageDialog(null, "A data deve estar no formato: DD/MM/AAAA", "ERRO DE DIGITAÇÃO", JOptionPane.ERROR_MESSAGE);
				}
	        	catch (SQLException exception)
				{
	        		exception.printStackTrace();
				}
	        	break;
	    }
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Ocorrencia ocorrencia = this.lista.get(rowIndex);
		
		switch(columnIndex)
		{
			case COD_MUNCP:
				return ocorrencia.getCodMuncp();
			case NOME_MUNCP:
				return ocorrencia.getNomeMuncp();
			case NOME_DOENCA:
				return ocorrencia.getNomeDoenca();
			case COD_DOENCA:
				return ocorrencia.getCodDoenca();
			case NUM_INFECTADOS:
				return ocorrencia.getNumInfectados();
			case NUM_MORTOS:
				return ocorrencia.getNumMortos();
			case NUM_INTERNADOS:
				return ocorrencia.getNumInternados();
			case DATA:
				return ocorrencia.getData();
			default:
				break;
		}
		return "-";
	}
	
	@Override
	public boolean isCellEditable(int row, int column) 
	{
	    return true;
	}

}