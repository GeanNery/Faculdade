# Conversor de número decimal para binário (permite inteiros ou frações)
numero = float(input("Valor a ser convertido: "))
binaryDigits = []

# Supondo que o número digitado foi 10.5
fracao = numero-(numero//1) # fracao = 0.5
numero = int(numero//1) # numero = 10

binaryDigits.insert(0, numero % 2)
while((numero//2) > 0):
  numero = numero // 2
  resto = numero % 2
  binaryDigits.insert(0, resto)

if fracao > 0:
  binaryDigits.append(".") # Se a fração for maior do que 0, adiciona-se um ponto indicando as casas decimais subsequentes.

  while (fracao > 0):
    fracao *= 2
    binaryDigits.append(int(fracao))
    if (fracao//1) > 0:
      fracao -= 1 # Se após a multiplicação, a parte inteira for maior do que 0, subtrai-se 1.
    else:
      continue

for i in binaryDigits:
  print(i, end="")