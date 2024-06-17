package github.com.mateusdalcantara.projeto_forum.domain.estudante;

import github.com.mateusdalcantara.projeto_forum.controllers.enums.CursorsDisponivel;

public record ListagemCompletaEstudante(Long id, String email, String cpf, String celular, CursorsDisponivel curso) {

    public ListagemCompletaEstudante(Estudante estudante) {
        this(estudante.getId(), estudante.getNome(), estudante.getCpf(), estudante.getCelular(), estudante.getCurso());
    }
}
