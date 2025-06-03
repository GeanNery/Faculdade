#PY01 - EXERCÍCIO 05
altura = int(input("Digite sua altura em centímetros(cm): "))
pesoIdeal = 50 + 2.3 * (altura - 152.4) / 2.54

metro = altura // 100 # Retorna a parte inteira do QUOCIENTE resultante da divisão.
centimetro = altura % 100 # Retorna o RESTO da divisão.

print(f"\nVocê mede {metro:.0f},{centimetro:.0f}m. O peso ideal para a sua estatura é {pesoIdeal:.0f}kg.")