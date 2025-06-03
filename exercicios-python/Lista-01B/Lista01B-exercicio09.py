#EXERCÍCIO 09
salario = float(input("Informe o salário em Real(R$): "))
aumento = salario + (salario * 15/100)
imposto = 8/100

print(f"""Salário bruto: R${salario:.2f}
\nAumento de 15% aplicado
Desconto de 8% em impostos aplicado
Salário líquido: R${aumento - (aumento * imposto):.2f}""")