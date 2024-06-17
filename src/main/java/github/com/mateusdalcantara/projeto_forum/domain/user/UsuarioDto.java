package github.com.mateusdalcantara.projeto_forum.domain.user;

import github.com.mateusdalcantara.projeto_forum.controllers.enums.RoleEnum;

public record UsuarioDto(
        String nome,
        String email,
        String login,
        String senha,
        RoleEnum role
) {
}