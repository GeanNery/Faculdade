print("TABELA DO ÍNDICE DE MASSA CORPOTAL (IMC)")
tabelaIMC: dict = {
'magreza':'menor que 18.5',
'normal':'entre 18.5 e 24.9',
'sobrepeso':'entre 25.0 e 29.9',
'obesidade':'entre 30.0 e 39.9',
'obesidade mórbida':'maior que 40.0'}
for i, j in tabelaIMC.items():
  print(f"{j.capitalize()}: {i.capitalize()}", end="\n")

A = float(input("\nAltura(m): "))
P = float(input("Peso(kg): "))
IMC = P/pow(A, 2)
print(f"SEU IMC: {IMC:.1f}")