#EXERCÍCIO 10
numero = int(input("Informe um número de 3 dígitos: "))
if len(str(numero)) == 3:
  C = numero // 100
  D = (numero - C*100) // 10
  U = numero - C*100 - D*10

  print(f"\nO número {numero} é composto por: \n{C} centenas; \n{D} dezenas; \n{U} unidades.")
else:
  print("\nEntrada inválida! Tente novamente.")