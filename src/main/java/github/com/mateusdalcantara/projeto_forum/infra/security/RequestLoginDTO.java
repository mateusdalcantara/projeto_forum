package github.com.mateusdalcantara.projeto_forum.infra.security;

public record RequestLoginDTO(
    String username,
    String password
) {
    
}
