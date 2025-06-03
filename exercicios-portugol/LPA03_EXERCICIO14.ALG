Algoritmo ",LPA03_exercicio14"

Var nome,sexo: caractere
   idade: inteiro
   mensalidade: real

Inicio
   escreva("Digite o nome do aluno:")
   leia(nome)
   escreva("Digite a idade do aluno:")
   leia(idade)
   escreva("Digite o sexo do aluno:")
   leia(sexo)
   mensalidade := 950 //Aqui é determinado o valor fixo da MENSALIDADE.
   
   se (sexo = "FEMININO") ou (sexo = "feminino") ou (sexo = "F") ou (sexo = "f") entao
      se idade > 40 entao
         mensalidade := mensalidade-(mensalidade*(20+15)/100)
      senao
         mensalidade := mensalidade-(mensalidade*20/100)
      fimse
   senao
      se idade > 40 entao
         mensalidade := mensalidade-(mensalidade*15/100)
      fimse
   fimse
   // Se o SEXO for feminino, o algoritmo irá verificar se a IDADE é maior do que 40.
   // Se a IDADE for maior do que 40, aplicará um desconto de 20% mais 15% à MENSALIDADE. Caso contrário, aplicará apenas 20%.
   // Se a primeira condição não for satisfeita; ou seja, se o SEXO não for feminino, o algoritmo irá verificar se a IDADE é maior do que 40 e aplicará 15% de desconto em caso verdadeiro.

   escreval("")
   escreval("DADOS DO ALUNO:")
   escreval("NOME: ",nome)
   escreval("IDADE:",idade)
   escreval("SEXO: ",sexo)
   escreval("")
   escreval("VALOR DA MENSALIDADE: R$",mensalidade:1:2)

Fimalgoritmo