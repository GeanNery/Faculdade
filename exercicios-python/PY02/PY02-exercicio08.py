#PY02 - EXERCÍCIO 08
valor = 600
parcelas = int(input("Digite a quantidade de parcelas: "))

if valor/parcelas < 50:
  print("\nNão pode ser financiado.")
else:
  print(f"\nValor do produto: R${valor:.2f} \nVocê vai pagar {parcelas}x de R${valor/parcelas:.2f}")