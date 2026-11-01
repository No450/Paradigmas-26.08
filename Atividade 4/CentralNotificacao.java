package notificacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CentralNotificacao {
    private final List<Notificacao> notificacoes = new ArrayList<>();

    public void adicionar(Notificacao notificacao) {
        if (notificacao == null) {
            throw new IllegalArgumentException("A notificacao nao pode ser nula.");
        }
        notificacoes.add(notificacao);
    }

    public void enviarTodas() {
        for (Notificacao notificacao : notificacoes) {
            notificacao.enviar();
            System.out.println();
        }
    }

    public void agendar(Notificacao notificacao, LocalDateTime dataHora) {
        if (notificacao instanceof Agendavel) {
            ((Agendavel) notificacao).agendar(dataHora);
        } else {
            System.out.println("Esta notificacao nao permite agendamento.");
        }
    }
}
