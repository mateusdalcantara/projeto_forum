package github.com.mateusdalcantara.projeto_forum.domain.topic;

import java.time.LocalDateTime;

public record ResponseTopicDTO(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime creationDateTime
) {
}
