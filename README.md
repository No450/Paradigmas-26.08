### Universidade Federal do Maranhão — UFMA

**Paradigma da Programação | 2026.2**

Desenvolvido por  
**Noam Willyan de Araujo Costa**

`Matrícula: 2023088523`


# Paradigma da Programação

> Repositório acadêmico destinado ao armazenamento de atividades, exercícios e projetos desenvolvidos durante a disciplina de **Paradigma da Programação** na **Universidade Federal do Maranhão (UFMA)**.


## Informações Acadêmicas

| Informação | Descrição |
|---|---|
| **Aluno** | Noam Willyan de Araujo Costa |
| **Matrícula** | 2023088523 |
| **Universidade** | Universidade Federal do Maranhão — UFMA |
| **Período Letivo** | 2026.2 |
| **Disciplina** | Paradigma da Programação |
| **Turma** | 246N34 |
| **Professor** | [Rondineli Seba Salomao](https://sigaa.ufma.br/sigaa/ava/index.jsf) |


## 📚 Sobre a Disciplina

Durante a disciplina serão desenvolvidos exercícios e atividades envolvendo conceitos de lógica de programação, algoritmos e diferentes paradigmas de desenvolvimento.


## 📂 Estrutura do Repositório

```text
Paradigma-da-Programacao/
│
├── README.md
│
├── atividades/
│   ├── atividade-01/
│   
│   
│
├── exercicios/
│
└── projetos/
```


## 📌 Finalidade

Este repositório possui **finalidade exclusivamente acadêmica** e será atualizado conforme o desenvolvimento das aulas e atividades propostas durante o período letivo **2026.2**.

## Pseudocódigo 

INICIO

    escrever("=== PROGRAMA DE TOMADA DE DECISÕES ===")

    escolha <- 1

    ENQUANTO escolha != 0 FACA

        escrever("Nome do cliente: ")
        leia(nome)

        escrever("Idade: ")
        leia(idade)

        escrever("Nome do produto: ")
        leia(nome_produto)

        escrever("Saldo disponível: R$ ")
        leia(saldo_disponivel)

        escrever("Preço unitário do produto: R$ ")
        leia(preco_produto)

        escrever("Quantidade desejada: ")
        leia(quantidade)

        valor_total <- preco_produto * quantidade


        // MOSTRAR CARACTERISTICAS DO PRODUTO/COMPRA
        escrever("================================")
        escrever("DADOS DA COMPRA")
        escrever("================================")

        escrever("Cliente: ", nome)
        escrever("Idade: ", idade, " anos")
        escrever("Produto: ", nome_produto)
        escrever("Preço unitário: R$ ", preco_produto)
        escrever("Quantidade: ", quantidade)
        escrever("Valor total: R$ ", valor_total)
        escrever("Saldo disponível: R$ ", saldo_disponivel)

        escrever("================================")


        // TOMADA DE DECISÃO

        SE idade >= 18 E saldo_disponivel >= valor_total ENTAO

            saldo_restante <- saldo_disponivel - valor_total

            escrever("COMPRA APROVADA!")
            escrever(nome, ", você pode comprar ", quantidade," unidade do produto ", nome_produto)
            escrever("Valor da compra: R$ ", valor_total)
            escrever("Saldo restante: R$ ", saldo_restante)

        SENAO SE idade >= 18 E saldo_disponivel < valor_total ENTAO

            valor_faltante <- valor_total - saldo_disponivel
            escrever("COMPRA NEGADA!")
            escrever("Você possui idade suficiente, porém não possui saldo suficiente.")
            escrever("Faltam R$ ", valor_faltante)

        SENAO SE idade < 18 E saldo_disponivel >= valor_total ENTAO
            escrever("COMPRA NEGADA!")
            escrever("Você possui saldo suficiente, porém não possui idade suficiente.")

        SENAO
            escrever("COMPRA NEGADA!")
            escrever("Você não possui idade e nem saldo suficientes.")

        FIMSE

        escrever("")
        escrever("Digite 0 para encerrar o programa.")
        escrever("Digite 1 para realizar outra compra.")
        leia(escolha)

    FIMENQUANTO
    escrever("=== PROGRAMA ENCERRADO ===")
FIM

