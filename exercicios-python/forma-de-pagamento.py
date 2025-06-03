def forma_de_pagamento(preco, digito):
  match digito:
    case 1: 
        porcentagem = 10
        valor_total = preco - (preco*porcentagem/100) # pagamento à vista
    case 2: 
        porcentagem = 15 
        valor_total = preco - (preco*porcentagem/100) # à vista no cartão de crédito
    case 3: 
      # pagamento parcelado:
      print("* Parcelamento em até 2x, preço de etiqueta sem juros; a partir de 3x, preço de etiqueta mais juros de 10%")
      parcelas = int(input("Quantidade de parcelas: "))
      porcentagem = 10

      while parcelas < 1 or parcelas > 12:
        print("Dígito inválido! Tente novamente")
        parcelas = int(input("Quantidade de parcelas: "))
      if parcelas <= 2:
        valor_total = preco
      else:
        valor_total = preco + (preco*porcentagem/100)
      print(f"\nVocê irá pagar {parcelas}x de R${valor_total/parcelas:.2f} \nTotal: R${valor_total:.2f}")
      return
    case _:
      print("Entrada inválida! Escolha uma forma de pagamento disponível")
      return
  print(f"* Desconto de {porcentagem}% aplicado \nTotal a pagar: R${valor_total:.2f}")

# saída
print(f"""CONDIÇÃO DE PAGAMENTO:
1 - À vista em dinheiro ou cheque
2 - À vista no cartão de crédito
3 - Parcelado\n""")
preco = float(input("Preço do produto (R$): "))
digito = int(input("Forma de pagamento (dígito): "))
forma_de_pagamento(preco, digito)