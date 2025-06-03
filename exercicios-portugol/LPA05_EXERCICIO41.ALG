Algoritmo "LPA05_EXERCICIO41"

Var numero, maiorNum, menorNum, contador: inteiro

Inicio
   contador := 1
   escreva("Digite um valor inteiro: ")
   leia(numero)

   enquanto numero <> 0 faca
      se contador = 1 entao
         maiorNum := numero
         menorNum := numero
      fimse
      //
      escreva("Digite um valor inteiro: ")
      leia(numero)
      contador := contador + 1
      //
      se (numero > maiorNum) e (numero <> 0) entao
         maiorNum := numero
      fimse
      se (numero < menorNum)  e (numero <> 0) entao
         menorNum := numero
      fimse
   fimenquanto
   
   escreval("")
   escreval("Maior número digitado:", maiorNum)
   escreval("Menor número digitado:", menorNum)
Fimalgoritmo