#LISTA 01B - EXERCÍCIO 08
dias_totais = int(input("Digite a quantidade de dias sem acidentes: "))

anos = dias_totais // 360 # Retorna a parte inteira do QUOCIENTE resultante da divisão.(//)
dias_restantes = dias_totais % 360 # Retorna o RESTO da divisão.(%)
meses = dias_restantes // 30
dias = dias_restantes % 30

print(f"\n{dias_totais} dias equivalem a {anos} ano(s), {meses} mese(s) e {dias} dia(s).")