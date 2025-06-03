#PY02 - EXERCÍCIO 06
letra = input("Digite uma letra: ")

if letra.lower() in "m":
  print("M - Masculino")
elif letra.lower() in "f":
    print("F - Feminino")
else:
  print("Inválido!")