#EXERCÍCIO 20
preco = float(input("Informe o valor da diária em Real(R$): "))
dias = int(input("Informe a quantia de dias trabalhados: "))
pagamento = preco * dias
IR = 8/100
valorFinal = pagamento - (pagamento * IR)

print(f"\nDesconto IR de 8% aplicado \nO valor a ser pago ao trabalhador será R${valorFinal:.2f}")