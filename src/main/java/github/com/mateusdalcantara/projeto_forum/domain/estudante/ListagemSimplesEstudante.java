package github.com.mateusdalcantara.projeto_forum.domain.estudante;

public record ListagemSimplesEstudante(Long id, String nome, String cpf) {

    public ListagemSimplesEstudante(Estudante estudante) {
        this(estudante.getId(), estudante.getNome(), estudante.getCpf());
    }
}
