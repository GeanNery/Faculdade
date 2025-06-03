Algoritmo "LPA02_exercicio08"

Var nome, cargo: caractere
   idade: inteiro
   salarioBruto, salarioReajus, salarioGratif, salarioLiqu: real

Inicio
   escreval("DADOS DO FUNCIONÁRIO:")
   escreva("NOME:")
   leia(nome)
   escreva("IDADE:")
   leia(idade)
   escreva("CARGO:")
   leia(cargo)
   escreva("SALÁRIO BRUTO: R$")
   leia(salarioBruto)

   salarioReajus := salarioBruto+(salarioBruto*18/100)
   salarioGratif := salarioReajus+(salarioReajus*20/100)
   salarioLiqu := salarioGratif-(salarioGratif*15/100)

   escreval("")
   escreval("Salário com reajuste de 18%: R$",salarioReajus:1:2)
   escreval("Gratificação de 20% sobre o salário bruto reajustado: R$",salarioGratif:1:2)
   escreval("Descontado 15% em impostos.")
   escreval("")
   escreval("SALÁRIO LÍQUIDO: R$",salarioLiqu:1:2)

Fimalgoritmo