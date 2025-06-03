package modelo;
public class Ocorrencia
{
	public int codMuncp;
	public String nomeMuncp;
	public String nomeDoenca;
	public String codDoenca;
	public int infectados;
	public int mortos;
	public int internados;
	public String data;

	public int getCodMuncp()
	{
		return codMuncp;
	}
	
	public String getNomeMuncp()
	{
		return nomeMuncp;
	}
	
	public String getNomeDoenca()
	{
		return nomeDoenca;
	}
	
	public String getCodDoenca()
	{
		return codDoenca;
	}
	
	public int getNumInfectados()
	{
		return infectados;
	}
	
	public int getNumMortos()
	{
		return mortos;
	}
	
	public int getNumInternados()
	{
		return internados;
	}
	
	public String getData()
	{
		return data;
	}
}