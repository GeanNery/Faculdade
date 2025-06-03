Algoritmo "LPA09_EXERCICIO71"

Var matrizinha: vetor[1..5,1..5] de inteiro
   i, j, k, l, cont: inteiro

Inicio
   cont := 1
   matrizinha[cont, 1] := 1

   para i de 1 ate 5 faca
      para j de 1 ate 5 faca
         se j = 5 entao
            se cont < 5 entao
               cont := cont+1
            fimse
            matrizinha[cont, cont] := 1
         fimse
      fimpara
   fimpara

   para k de 1 ate 5 faca
      para l de 1 ate 5 faca
         escreva(matrizinha[k, l])
         se l = 5 entao
            escreval()
         fimse
      fimpara
   fimpara

Fimalgoritmo