Algoritmo "algoritmo_provaLPA_19-09-24"

Var formaPag, parcela: inteiro
   preco: real

Inicio
   preco := 100
   formaPag := 0
   escreval("Preço do produto: R$", preco)
   escreval("")
   escreval("1 - Dinheiro")
   escreval("2 - Cheque")
   escreval("3 - Cartão de crédito")

   enquanto (formaPag < 1) ou (formaPag > 3) faca
      escreval("Informe o dígito referente à forma de pagamento: ")
      leia(formaPag)
      se (formaPag < 1) ou (formaPag > 3) entao
         escreval("")
         escreval("Dígito inválido! Tente novamente.")
      fimse
   fimenquanto

   escolha formaPag
   caso 1 ate 2
      preco := preco-(preco*10/100)
      escreval("")
      escreva("Valor a pagar: R$", preco)
   caso 3
      escreval("")
      escreval("Em quantas vezes deseja parcelar sua compra?")
      leia(parcela)
      
      se parcela = 1 entao
         preco := preco-(preco*15/100)
      senao
         preco := preco+(preco*10/100)
      fimse
      escreval("")
      escreval("Você irá pagar", parcela, "x vezes de R$", preco/parcela:1:2)
      escreva("Total a pagar: R$", preco)
   fimescolha
Fimalgoritmo