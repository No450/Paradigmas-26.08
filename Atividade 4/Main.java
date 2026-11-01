package notificacoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            verificarConfiguracao();

            System.out.print("Email destinatario: ");
            String destinatario = scanner.nextLine().trim();
            System.out.print("Mensagem: ");
            String mensagem = scanner.nextLine().trim();

            CentralNotificacao central = new CentralNotificacao();
            central.adicionar(new EmailNotificacao(destinatario, mensagem));
            central.enviarTodas();
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e) {
            System.err.println("Nao foi possivel enviar a notificacao: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void verificarConfiguracao() {
        exigirVariavel("GMAIL_ADDRESS");
        exigirVariavel("GMAIL_APP_PASSWORD");
    }

    private static void exigirVariavel(String nome) {
        String valor = System.getenv(nome);
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Configure a variavel de ambiente " + nome + ".");
        }
    }
}
