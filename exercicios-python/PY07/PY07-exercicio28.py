#PY07 - EXERCÍCIO 28
numLista = []
listaPar = []
listaImpar = []

for i in range(0,10):
  num = int(input("Digite o número: "))
  numLista.append(num)
  if num % 2 == 0:
    listaPar.append(num)
  else:
    listaImpar.append(num)

print(f"\nNúmeros total: {numLista} \nNúmeros pares: {listaPar} \nNúmeros ímpares: {listaImpar}")