#PY04 - EXERCÍCIO 16
nome, sexo = "", ""
idade = int(0)
salario = float(0)

#NOME
while(nome == ""):
  nome = input("Digite o nome: ")
  if nome != "":
    break
  print("Inválido")

#IDADE
while(idade < 14 or idade > 80):
  idade = int(input("Digite a idade: "))
  if idade > 0:
    break
  print("Inválido")

#SEXO
while(sexo.lower() != "masculino" and sexo.lower() != "m" and sexo.lower() != "feminino" and sexo.lower() != "f"):
  sexo = input("Digite o sexo: ")
  if not(sexo.lower() != "masculino" and sexo.lower() != "m" and sexo.lower() != "feminino" and sexo.lower() != "f"):
    break
  print("Inválido")

if sexo.lower()[0] == "m":
  sexo = "masculino"
elif sexo.lower()[0] == "f":
  sexo = "feminino"

#SALÁRIO
while(salario <= 0):
  salario = float(input("Digite o salário: "))
  if salario > 0:
    break
  print("Inválido")

print(f"\n{nome.capitalize()}; {idade} ano(s); sexo {sexo}; salário de R${salario:.2f}")