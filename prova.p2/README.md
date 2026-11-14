# Sistema de notas em Python

Programa simples para cadastrar as notas de um aluno, calcular a média e mostrar se ele foi aprovado ou reprovado. O código foi organizado com programação orientada a objetos (POO).

## Como funciona

Ao executar o programa, é solicitado o nome do aluno e, em seguida, cinco notas. No final, são exibidos:

- nome do aluno;
- notas cadastradas;
- média das notas;
- situação do aluno (aprovado ou reprovado);
- notas que ficaram acima da média.

A média mínima para aprovação é **7,0**. As notas devem estar entre **0 e 10**.

## Como executar

É necessário ter o Python 3 instalado.

Salve o código em um arquivo chamado `main.py` e execute no terminal:

```bash
python3 main.py
```

No Windows, também pode ser usado:

```bash
python main.py
```

## Exemplo

```text
Digite o nome do aluno: Carlos
Digite a 1ª nota: 8
Digite a 2ª nota: 9
Digite a 3ª nota: 6
Digite a 4ª nota: 7
Digite a 5ª nota: 10

Aluno: Carlos
Notas: [8.0, 9.0, 6.0, 7.0, 10.0]
Média: 8.00
Situação: Aprovado
Notas acima da média: [9.0, 10.0]
```

## Organização do código

A classe `Aluno` reúne os dados e as operações do programa:

- `__init__`: guarda o nome e cria a lista de notas;
- `adicionar_nota`: adiciona uma nota, desde que esteja entre 0 e 10;
- `calcular_media`: calcula a média das notas cadastradas;
- `verificar_aprovacao`: verifica se a média é maior ou igual a 7;
- `notas_acima_media`: separa as notas maiores que a média calculada;
- `exibir_resultado`: mostra os resultados no terminal.

## Observação

Este é um exercício de POO. A entrada de notas ainda pode ser melhorada para tratar casos em que o usuário digita letras ou outros valores inválidos.
