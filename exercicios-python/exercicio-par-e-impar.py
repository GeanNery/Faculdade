contador = 0

while(contador < 10):
  numero = int(input("Digite um número: "))
  contador = contador + 1
  
  if numero % 2 == 0 and numero != 0:
    print("O NÚMERO", numero, "É PAR")
  elif numero == 0:
    print("\nFim de execução.")
    break
  else:
    print("O NÚMERO", numero, "É ÍMPAR")
else:
  print("JÁ FORAM DIGITADOS OS 10 NUMEROS")