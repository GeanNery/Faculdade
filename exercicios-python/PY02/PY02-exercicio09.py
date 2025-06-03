#PY02 - EXERCÍCIO 09
valor1 = float(input("Digite o valor do primeiro produto: R$"))
valor2 = float(input("Digite o valor do segundo produto: R$"))
valor3 = float(input("Digite o valor do terceiro produto: R$"))

if valor1 < valor2 and valor3:
  print(f"\nO produto a ser comprado é o Produto nº1 por R${valor1:.2f}.")
elif valor2 < valor3:
  print(f"\nO produto a ser comprado é o Produto nº2 por R${valor2:.2f}.")
else:
  print(f"\nO produto a ser comprado é o Produto nº3 por R${valor3:.2f}.")