#LISTA DE EXERCÍCIOS - 01
print("CALCULADORA DE TABUADA (1 ao 10)")
numero = int(input("Digite um número inteiro: "))
contagem = 1

print(f"\nTABUADA DO {numero}:")
while(contagem <= 10):
  print(f"{numero} x {contagem} = {numero*contagem}")
  contagem += 1