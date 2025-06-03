package Exemplo;

public class Carro
{
	String cor;
	static int velocidadeAtual = 0;
	
	public static void Acelerar()
	{
		velocidadeAtual += 10;
	}
	
	public static void Frear()
	{
		velocidadeAtual -= 10;
	}
}