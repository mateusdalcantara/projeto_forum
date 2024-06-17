package github.com.mateusdalcantara.projeto_forum.infra.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponseDTO(
    LocalDateTime timestamp,
    Integer status,
    String message,
    String path
) {
    
}
