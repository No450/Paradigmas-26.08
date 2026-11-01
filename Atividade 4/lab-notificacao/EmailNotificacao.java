package notificacoes;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailNotificacao extends Notificacao implements Agendavel {
    public EmailNotificacao(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    protected void enviarConteudo() {
        String remetente = obterVariavel("GMAIL_ADDRESS");
        String senhaDeApp = obterVariavel("GMAIL_APP_PASSWORD");

        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.host", "smtp.gmail.com");
        propriedades.put("mail.smtp.port", "587");
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.starttls.enable", "true");
        propriedades.put("mail.smtp.starttls.required", "true");
        propriedades.put("mail.smtp.connectiontimeout", "10000");
        propriedades.put("mail.smtp.timeout", "10000");
        propriedades.put("mail.smtp.writetimeout", "10000");

        Session sessao = Session.getInstance(propriedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senhaDeApp);
            }
        });

        try {
            MimeMessage email = new MimeMessage(sessao);
            email.setFrom(new InternetAddress(remetente));
            email.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(getDestinatario(), true));
            email.setSubject("Notificacao", "UTF-8");
            email.setText(getMensagem(), "UTF-8");
            Transport.send(email);
        } catch (MessagingException e) {
            throw new IllegalStateException(
                    "Falha ao enviar email. Confira a conta Gmail, a senha de app, "
                            + "o destinatario e a conexao com a internet.",
                    e);
        }
    }

    @Override
    public void agendar(LocalDateTime dataHora) {
        validarHorario(dataHora);
        long atraso = Duration.between(LocalDateTime.now(), dataHora).toMillis();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            try {
                enviar();
            } catch (IllegalStateException e) {
                System.err.println("Falha no envio agendado: " + e.getMessage());
            } finally {
                executor.shutdown();
            }
        }, atraso, TimeUnit.MILLISECONDS);
        System.out.println("Email agendado para " + dataHora
                + ". Mantenha este programa aberto ate o envio.");
    }

    private String obterVariavel(String nome) {
        String valor = System.getenv(nome);
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Configure a variavel de ambiente " + nome + ".");
        }
        return valor;
    }
}
