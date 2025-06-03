Algoritmo "LPA04_exercicio30"

Var nome, categoria: caractere
   idade: inteiro

Inicio
   escreval("CLASSIFICAÇÃO DE JOGADORES")
   escreval("Categoria:          Idade:")
   escreval("Fraldinha...........Até 4 anos")
   escreval("Infantil............5 a 10 anos")
   escreval("Juvenil.............11 a 17 anos")
   escreval("Profissional........18 a 40 anos")
   escreval("Senior..............Mais de 40 anos")
   escreval("")
   escreva("Digite o nome: ")
   leia(nome)
   escreva("Digite a idade: ")
   leia(idade)
   escreval("")

   escolha idade
   caso 1 ate 4
      categoria := "FRALDINHA"
      se(idade = 1)entao
         escreval(nome, ",",idade," ano, ","categoria ",categoria,".")
      senao
         escreval(nome, ",",idade," anos, ","categoria ",categoria,".")
      fimse
   caso 5 ate 10
      categoria := "INFANTIL"
      escreval(nome, ",",idade," anos, ","categoria ",categoria,".")
   caso 11 ate 17
      categoria := "JUVENIL"
      escreval(nome, ",",idade," anos, ","categoria ",categoria,".")
   caso 18 ate 40
      categoria := "PROFISSIONAL"
      escreval(nome, ",",idade," anos, ","categoria ",categoria,".")
   outrocaso
      se(idade>40)entao
         categoria := "SENIOR"
         escreval(nome, ",",idade," anos, ","categoria ",categoria,".")
      senao
         escreval("VALORES INVÁLIDOS")
      fimse
   fimescolha

Fimalgoritmo