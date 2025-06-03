#PY02 - EXERCÍCIO 10
nome = input("Digite o seu nome: ")
turno = input("Informe o seu turno: ")

if turno.lower() in "matutino" or turno[0] == "m":
  print(f"\nBom dia, {nome.capitalize()}!")
elif turno.lower() in "vespertino" or turno[0] == "v":
  print(f"\nBoa tarde, {nome.capitalize()}!")
elif turno.lower() in "noturno" or turno[0] == "n":
  print(f"\nBoa noite, {nome.capitalize()}!")
else:
  print(f"\nValor inválido!")