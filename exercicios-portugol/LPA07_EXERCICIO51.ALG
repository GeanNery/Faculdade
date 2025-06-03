Algoritmo "LPA07_exercicio51"

Var quantMasc, quantFem, cont: inteiro
   altura, maiorAlt, altFem: real
   sexo, sexoAlt, resp: caractere

Inicio
   quantMasc := 0
   quantFem := 0
   maiorAlt := 0
   altFem := 0
   cont := 0

   repita
      //Entrada
      escreva("Digite a altura: ")
      leia(altura)
      sexo := ""
      escreva("Digite o sexo: ")
      leia(sexo)

      //Formatação do caractere
      se(sexo = "m")ou(sexo = "M")entao
         quantMasc := quantMasc + 1
         sexo := "Masculino"
      senao
         se(sexo = "f")ou(sexo = "F")entao
            quantFem := quantFem + 1
            altFem := altFem + altura
            sexo := "Feminino"
         fimse
      fimse
      cont := cont + 1

      //Maior altura; Sexo da pessoa mais alta.
      se(cont = 0)entao
         maiorAlt := altura
         sexoAlt := sexo
      senao
         se(altura > maiorAlt)entao
            maiorAlt := altura
            sexoAlt := sexo
         fimse
      fimse

      //Resposta do usuário
      escreval("Deseja continuar? (S/N)")
      leia(resp)
      enquanto (resp <> "s")e(resp <> "S")e(resp <> "n")e(resp <> "N") faca
         escreval("RESPOSTA INVÁLIDA! DIGITE NOVAMENTE")
         escreval("Deseja continuar? (S/N)")
         leia(resp)
      fimenquanto
      escreval()
   ate(resp = "n")ou(resp = "N")

   //Saída
   escreval("Maior altura do grupo:", maiorAlt)
   se(quantFem > 0)entao
      escreval("Média de altura das mulheres:", altFem/quantFem)
   senao
      escreval("Média de altura das mulheres:", 0)
   fimse
   escreval("Quantidade de homens:", quantMasc)
   escreva("Sexo da pessoa mais alta: ", sexoAlt)
Fimalgoritmo