Algoritmo "LPA02_exercicio09"

Var nome: caractere
   horas, salarioBruto, salarioLiqu, INSS, IR: real
   dependentes: inteiro

Inicio
   escreval("FICHA DO FUNCION�RIO:")
   escreva("Nome: ")
   leia(nome)
   escreva("Horas trabalhadas: ")
   leia(horas)
   escreva("N� de dependentes: ")
   leia(dependentes)

   salarioBruto := (12*horas)+(40*dependentes)
   INSS := salarioBruto*8/100
   IR := salarioBruto*5/100
   salarioLiqu := salarioBruto-INSS-IR

   escreval("")
   escreval("Sal�rio bruto: R$",salarioBruto:1:2)
   escreval("Desconto INSS: R$",INSS:1:2)
   escreval("Desconto IR: R$",IR:1:2)
   escreval("")
   escreval("Sal�rio l�quido: R$", salarioLiqu:1:2)

Fimalgoritmo