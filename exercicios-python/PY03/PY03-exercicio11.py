#PY03 - EXERCICIO 11
ano = int(input("Digite o ano: "))

if ano % 4 == 0 and ano % 100 != 0 or ano % 400 == 0:
  print(f"\n{ano} é ano bissexto.")
else:
  print(f"\n{ano} é ano não bissexto.")