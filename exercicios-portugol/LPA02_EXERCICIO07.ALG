Algoritmo "LPA02_exercicio07"

Var capitalInicial, rendimento, juroFixo, taxaADM, valorFinal: real

Inicio
   escreva("Capital inicial: R$")
   leia(capitalInicial)

   juroFixo := 1.05
   taxaADM := juroFixo*20/100
   rendimento := juroFixo-taxaADM

   valorFinal := capitalInicial+(capitalInicial*rendimento/100)

   escreval("Juro de aplica��o: 1.05%a.m.")
   escreval("Taxa de administra��o: 20% do juro")
   escreval("")
   escreval("Valor ap�s a aplica��o: R$", valorFinal:1:2)

Fimalgoritmo