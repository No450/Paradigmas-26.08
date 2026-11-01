package notificacoes;

public class SmsNotificacao extends Notificacao {
    public SmsNotificacao(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    protected void enviarConteudo() {
        throw new UnsupportedOperationException(
                "Envio de SMS desativado: configure um provedor de SMS antes de usar este canal.");
    }
}
