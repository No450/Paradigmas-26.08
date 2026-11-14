class Aluno:
    
    # Construtor
    def __init__(self):
        self.lista_notas = []

    # Método para cadastrar as notas
    def notas(self):
        for i in range(5):
            nota = float(input("Digite a nota: "))
            self.lista_notas.append(nota)

        return self.lista_notas

    # Método para calcular a média
    def media(self):
        soma = sum(self.lista_notas)
        media = soma / len(self.lista_notas)
        return media

    # Método para verificar notas maiores ou iguais a 7
    def notas_acima_media(self):
        aprovados = list(
            filter(lambda nota: nota >= 7, self.lista_notas)
        )

        return aprovados

    # Método para verificar aprovação
    def aprovacao(self):
        if self.media() < 7:
            return "Reprovado"
        elif self.media() >= 7:
            return "Aprovado"
        else:
            return "Opção inválida"

aluno = Aluno()
# Cadastrando as notas
aluno.notas()

# Exibindo os resultados
print("Média:", aluno.media())
print("Status:", aluno.aprovacao())
print("Todas as notas:", aluno.lista_notas)
print("Notas acima da média:", aluno.notas_acima_media())
