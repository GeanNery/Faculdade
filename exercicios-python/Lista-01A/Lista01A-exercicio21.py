#EXERCÍCIO 21
precoTotal = float(input("Informe o valor do produto em Real(R$): "))
precoDesc = precoTotal - (precoTotal * 10/100)
comissaoV = precoDesc * 5/100
comissaoP = precoTotal * 5/100
parcela = precoTotal/3

print(f"""\nValor com desconto de 10% à vista: R${precoDesc:.2f}
Valor de cada parcela em 3x sem juros: R${parcela:.2f}
Comissão por venda à vista: R${comissaoV:.2f}
Comissão por venda parcelada: R${comissaoP:.2f}""")