package notificacoes;

public abstract class Notificacao {
    private final String destinatario;
    private final String mensagem;

    protected Notificacao(String destinatario, String mensagem) {
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException("O destinatario e obrigatorio.");
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("A mensagem e obrigatoria.");
        }

        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    public final void enviar() {
        validar();
        preparar();
        enviarConteudo();
        confirmarEnvio();
    }

    protected abstract void enviarConteudo();

    protected final String getDestinatario() {
        return destinatario;
    }

    protected final String getMensagem() {
        return mensagem;
    }

    private void validar() {
        System.out.println("Validando notificacao...");
    }

    private void preparar() {
        System.out.println("Preparando mensagem...");
    }

    private void confirmarEnvio() {
        System.out.println("Notificacao enviada com sucesso.");
    }
}
