# Início: 12/10/2024
# Término: 26/10/2024

import math, random
keyMin, keyMax = 17, 19 # Valores menores que 17 podem ocasionar erros.

print(f"0 - Criptografar \n1 - Descriptografar (Soma)\n2 - Descriptografar (Padrão)")
resposta = int(input("Informe o dígito: "))
print()

def geraPrimo(number = None):
  while True:
    isPrime = True
    number = random.randint(keyMin, keyMax)
    for i in range(2, number):
      if number % i == 0:
        isPrime = False
        break
    if isPrime:
      break
  return number

def decifrarMensagem(msngm, entradaCifrada = []):
  if resposta != 0:
    for c in cifras:
      entradaCifrada.append(int(c))

  decrypText = []
  if resposta == 1 or resposta == 0:
    for l, value in enumerate(entradaCifrada):
      value -= l # Subtrai o índice do elemento para retornar o valor original.
      character = (value**D) % N
      decrypText.append(chr(character))
  elif resposta == 2:
    for k in entradaCifrada:
      character = (k**D) % N
      decrypText.append(chr(character))
  return decrypText

if resposta < 0 or resposta > 2:
  print("Dígito inválido! Tente novamente.")
else:
  message = input("Insira a mensagem: ")
  cifras = message.split(" ")

  if resposta == 0 and len(message) <= 128:
    # Gera P e Q:
    P = geraPrimo()
    while True:
      Q = geraPrimo()
      if Q != P:
        break
    N = P * Q
    phiN = (P-1)*(Q-1)

    # Encontra o valor E:
    while True:
      E = random.randint(2, phiN-1) # 1 < E < phi(N)
      mdc = math.gcd(E, phiN)
      if mdc == 1:
        break
    # Encontra o valor D:
    D = 1
    while True:
      if ((D*E) % phiN == 1) and D != E:
        break
      D += 1

    # Criptografa o texto:
    encrypText = []
    for k, char in enumerate(message):
      ordinary = (ord(char)**E) % N
      ordinary += k # Soma o valor do elemento ao índice para evitar repetições.
      encrypText.append(ordinary)

    print(f"\nP[{P}]    Q[{Q}]    N[{N}]    phi(N)[{phiN}]    E[{E}]    D[{D}]")
    print(f"Chaves públicas: {N}, {E} (Usadas para criptografar)")
    print(f"Chave privada: {D} (Usada para descriptografar) \n")
    print("Mensagem cifrada:", end=" ")
    for i in encrypText:
      print(i, end=" ")
    print(f"\nMensagem decifrada: {decifrarMensagem(message, encrypText)}")
  elif resposta != 0 and len(cifras) <= 128:
    N = int(input("N: "))
    D = int(input("D: "))

    print("\nMensagem original:", end=" ")
    for string in decifrarMensagem(message):
      print(string, end="")
  else:
    print("\n*Limite de caracteres excedido! Máximo 128.")