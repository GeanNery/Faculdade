#LISTA DE EXERCÍCIOS - 01/03
print("CALCULADORA DE TABUADA PERSONALIZADA")
numero = int(input("Digite um valor para a tabuada: "))
inicial = int(input("Início: "))
final = int(input("Fim: "))

if numero > 0 and inicial > 0 and final > 0:
  print(f"\nTABUADA DO {numero} ({inicial} ao {final})")

  if inicial <= final: # Se o valor inicial for menor do que o valor final, a tabuada será exibida em ordem crescente.
    while(inicial <= final):
      print(f"{numero} x {inicial} = {numero * inicial}")
      inicial += 1
  elif inicial >= final: # Se o valor inicial for maior do que o valor final, a tabuada será exibida em ordem decrescente.
    while(inicial >= final):
      print(f"{numero} x {inicial} = {numero * inicial}")
      inicial -= 1
else: # Se um dos valores digitados for negativo ou zero, uma mensagem de erro será exibida.
  print("\nVALORES INVÁLIDOS")