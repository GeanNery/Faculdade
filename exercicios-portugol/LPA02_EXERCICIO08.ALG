Algoritmo "LPA02_exercicio08"

Var nome, cargo: caractere
   idade: inteiro
   salarioBruto, salarioReajus, salarioGratif, salarioLiqu: real

Inicio
   escreval("DADOS DO FUNCION�RIO:")
   escreva("NOME:")
   leia(nome)
   escreva("IDADE:")
   leia(idade)
   escreva("CARGO:")
   leia(cargo)
   escreva("SAL�RIO BRUTO: R$")
   leia(salarioBruto)

   salarioReajus := salarioBruto+(salarioBruto*18/100)
   salarioGratif := salarioReajus+(salarioReajus*20/100)
   salarioLiqu := salarioGratif-(salarioGratif*15/100)

   escreval("")
   escreval("Sal�rio com reajuste de 18%: R$",salarioReajus:1:2)
   escreval("Gratifica��o de 20% sobre o sal�rio bruto reajustado: R$",salarioGratif:1:2)
   escreval("Descontado 15% em impostos.")
   escreval("")
   escreval("SAL�RIO L�QUIDO: R$",salarioLiqu:1:2)

Fimalgoritmo