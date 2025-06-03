package Exemplo;

public class ExecutaCarro
{
	public static void main(String[] args)
	{
		//Carro carro = new Carro();
		Carro.Acelerar();
		Carro.Acelerar();
		Carro.Frear();
		System.out.print(Carro.velocidadeAtual);
		System.exit(0);
	}
}
