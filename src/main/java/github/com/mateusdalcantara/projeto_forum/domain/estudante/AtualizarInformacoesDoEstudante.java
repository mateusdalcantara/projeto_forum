package github.com.mateusdalcantara.projeto_forum.domain.estudante;

import github.com.mateusdalcantara.projeto_forum.controllers.enums.CursorsDisponivel;


public record AtualizarInformacoesDoEstudante(
        Long id,
        String nome,
        String celular,
        CursorsDisponivel curso) {
}
