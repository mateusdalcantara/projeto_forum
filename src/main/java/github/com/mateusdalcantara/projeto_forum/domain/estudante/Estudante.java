package github.com.mateusdalcantara.projeto_forum.domain.estudante;

import github.com.mateusdalcantara.projeto_forum.controllers.enums.CursorsDisponivel;
import github.com.mateusdalcantara.projeto_forum.domain.user.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "estudantes")
@Table(name = "Estudante")
@EqualsAndHashCode(of = "id")
public class Estudante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String matricula;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String celular;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Getter
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private CursorsDisponivel curso;

    private Boolean ativo;

    public Estudante(CadastrarEstudante dados){
        this.ativo = true;
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.celular = dados.celular();
        this.matricula = dados.matricula();
        this.curso = CursorsDisponivel.fromString(dados.curso());
    }

    public void atualizarInformacoes(AtualizarInformacoesDoEstudante dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.celular() != null){
            this.celular = dados.celular();
        }
        if (dados.curso() != null)
            this.curso = dados.curso();
    }

    public void excluir(){
        this.ativo = false;
    }
}
