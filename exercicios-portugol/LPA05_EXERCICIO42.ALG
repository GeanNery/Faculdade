Algoritmo "LPA05_EXERCICIO42"

Var sexo, resposta, sexoAlt: caractere
   altura, maiorAlt, altFem, mediaFem: real
   quantMasc, quantFem, contador: inteiro

Inicio
   enquanto (resposta <> "n") e (resposta <> "N") faca
      escreva("Altura: ")
      leia(altura)
      escreva("Sexo: ")
      leia(sexo)
      //
      se (sexo = "m") ou (sexo = "M") entao
         sexo := "Masculino"
         quantMasc := quantMasc + 1
      senao
         se (sexo = "f") ou (sexo = "F") entao
            sexo := "Feminino"
            quantFem := quantFem + 1
            altFem := altFem + altura
         fimse
      fimse
      //
      contador := contador + 1
      se contador = 1 entao
         maiorAlt := altura
         sexoAlt := sexo
      senao
         se altura > maiorAlt entao
            maiorAlt := altura
            sexoAlt := sexo
         senao
            sexoAlt := "Indefinido"
         fimse
      fimse
      //
      se quantFem > 0 entao
         mediaFem := altFem/quantFem
      senao
         mediaFem := 0
      fimse
      //
      escreva("Deseja continuar? (S/N): ")
      leia(resposta)
   fimenquanto
   //
   escreval("")
   escreval("Maior altura do grupo:", maiorAlt)
   escreval("Média da altura das mulheres:", mediaFem)
   escreval("Quantidade de homens:", quantMasc)
   escreval("Sexo da pessoa mais alta: ", sexoAlt)
Fimalgoritmo