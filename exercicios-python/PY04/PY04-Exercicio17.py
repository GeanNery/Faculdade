#PY04 - EXERCÍCIO 17
quantidade = int(input("Digite quantos números que deseja avaliar: "))
maiorNumero = float("-inf") #Inicia com um valor negativo infinito. Dessa forma, qualquer valor digitado será maior do que o inicial.

while(quantidade > 0):
  numero = int(input("Digite um número: "))
  if numero > maiorNumero: #Se número digitado for maior do que {maiorNumero}, {maiorNumero} receberá seu valor.
    maiorNumero = numero
  quantidade -= 1

print(f"\nMaior número digitado: {maiorNumero}")