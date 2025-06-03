Algoritmo "LPA02_exercicio07"

Var capitalInicial, rendimento, juroFixo, taxaADM, valorFinal: real

Inicio
   escreva("Capital inicial: R$")
   leia(capitalInicial)

   juroFixo := 1.05
   taxaADM := juroFixo*20/100
   rendimento := juroFixo-taxaADM

   valorFinal := capitalInicial+(capitalInicial*rendimento/100)

   escreval("Juro de aplicação: 1.05%a.m.")
   escreval("Taxa de administração: 20% do juro")
   escreval("")
   escreval("Valor após a aplicação: R$", valorFinal:1:2)

Fimalgoritmo