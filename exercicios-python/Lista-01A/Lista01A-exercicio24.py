#EXERCÍCIO 24
segTotal = float(input("Digite o valor em segundos: "))
H = segTotal//3600
M = (segTotal - H * 3600) // 60
S = (segTotal - H * 3600) - M * 60
Cent = (segTotal - segTotal // 1) * 100
#Ms = (segTotal - segTotal // 1) * 1000

print(f"""\n{int(H):02}:{int(M):02}:{int(S):02}:{int(Cent):02}
{int(H)} hora(s), {int(M)} minuto(s), {int(S)} segundo(s) e {int(Cent)} centésimo(s) de segundo.""")