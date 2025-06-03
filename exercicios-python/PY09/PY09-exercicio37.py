#EXERCÍCIO 37
def somaImposto(custo, taxa):
  soma = custo + (custo*taxa/100)
  return soma

cont = 1
lista = []
while True:
  custoProduto = float(input(f"[Produto Nº{cont}] Custo(R$): "))
  taxaImposto = float(input("Taxa(%): "))
  lista.append(somaImposto(custoProduto, taxaImposto))
  cont += 1
  resposta = input("Continuar? (S/N) ")
  print()
  if resposta[0].lower() == "s":
    continue
  else:
    break

cont = 1
print("VALOR FINAL:")
for i in lista:
  print(f"Produto Nº{cont}: R${i:.2f}")
  cont += 1