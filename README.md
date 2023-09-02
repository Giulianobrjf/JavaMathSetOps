# Conjuntos e Operações Matemáticas em Java

Este é um projeto em Java que oferece uma série de operações matemáticas relacionadas a conjuntos, incluindo verificação de pertencimento, união, interseção, produto cartesiano e muito mais.

## Funcionalidades

- **Pertencimento**: Verifica se um número pertence a um conjunto.
- **Contido ou Igual**: Verifica se um conjunto está contido em outro ou se são iguais.
- **Operações Básicas**: Realiza operações como união, interseção e produto cartesiano.
- **Conjunto das Partes**: Gera todas as combinações possíveis dos elementos de um conjunto.
- **Relações Matemáticas**: Cria relações entre elementos de conjuntos com base em regras matemáticas.
- **Propriedades de Relações**: Verifica propriedades matemáticas das relações, como ser funcional, injetiva, total ou sobrejetiva.

## Como Usar

1. Clone o repositório para o seu ambiente de desenvolvimento.
2. Abra o arquivo `Main.java` e execute o código a partir do método `main`.
3. Siga as instruções do menu interativo para realizar as operações desejadas.
4. Você pode pré-carregar conjuntos com valores iniciais no código.

## Pré-requisitos

- Java Development Kit (JDK) instalado.

## Exemplos

Aqui estão alguns exemplos de uso das funcionalidades:

```java
// Verificar pertencimento
int valor = 5;
if (e.pertence(valor, conjuntoA)) {
    System.out.println(valor + " Pertence ao conjunto A");
} else {
    System.out.println(valor + " Não Pertence ao conjunto A");
}

// Realizar união de conjuntos
List<Integer> resultadoUniao = e.uniao(conjuntoA, conjuntoB);
System.out.println("União de A e B: " + resultadoUniao);
