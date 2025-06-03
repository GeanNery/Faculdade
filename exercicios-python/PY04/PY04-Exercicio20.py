#PY04 - EXERCÍCIO 20
numero = int(input("Digite um número inteiro: "))
print(f"\nNúmeros primos de 1 a {numero}:")

while(numero > 0):
  if numero % 2 != 0:
    if numero > 1:
      print(numero, end=", ")
    else:
      print(numero, end=".")
  numero -= 1