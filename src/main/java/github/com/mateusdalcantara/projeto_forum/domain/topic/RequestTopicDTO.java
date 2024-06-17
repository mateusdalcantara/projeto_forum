package github.com.mateusdalcantara.projeto_forum.domain.topic;

import org.springframework.lang.NonNull;

public record RequestTopicDTO(
    @NonNull
    String titulo,
    @NonNull
    String curso,
    @NonNull
    String autor,
    @NonNull
    String mensagem
){
}
