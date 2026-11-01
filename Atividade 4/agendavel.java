package notificacoes;

import java.time.LocalDateTime;

public interface Agendavel {
    void agendar(LocalDateTime dataHora);

    default void validarHorario(LocalDateTime dataHora) {
        if (dataHora == null || !dataHora.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("O agendamento deve ser para o futuro.");
        }
    }
}
