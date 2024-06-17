package github.com.mateusdalcantara.projeto_forum.infra.security;

import lombok.Builder;

@Builder
public record TokenResponseDto(String token, String refreshToken) {
}
