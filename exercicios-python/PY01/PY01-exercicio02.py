#PY01 - EXERCÍCIO 02
valorReal = float(input("Valor em Reais: R$"))
valorDolar = float(0.1828)

print(f"\nR${valorReal:.2f} equivale a U${valorReal*valorDolar:.2f}")