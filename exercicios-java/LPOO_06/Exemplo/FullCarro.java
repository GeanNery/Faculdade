package Exemplo;

public class FullCarro
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
	
	public static void main(String[] args)
	{
		Acelerar();
		Acelerar();
		Frear();
		System.out.print(velocidadeAtual);
		System.exit(0);
	}
}
