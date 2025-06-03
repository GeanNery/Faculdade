#PY02 - EXERCÍCIO 07
num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o segundo número: "))
num3 = float(input("Digite o terceiro número: "))

#print(f"\n{max(num1, num2, num3)}") #jeito certo de fazer
if num1 > num2 and num3:
  print(num1)
elif num2 > num3:
  print(num2)
else:
  print(num3)