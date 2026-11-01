package notificacoes;

public class PushNotificacao extends Notificacao {
    public PushNotificacao(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    protected void enviarConteudo() {
        throw new UnsupportedOperationException(
                "Envio push nao implementado: configure um servico de notificacoes push.");
    }
}
