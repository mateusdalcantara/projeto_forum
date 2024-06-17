package github.com.mateusdalcantara.projeto_forum.domain.topic;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Table(name = "topicos")//JPA
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String curso;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String mensagem;


    @Getter
    @Column(updatable = false) @CreatedDate
    private LocalDateTime creation_date_time;

    public Topic(String titulo, String curso, String autor, String mensagem) {
        this.titulo = titulo;
        this.curso = curso;
        this.autor = autor;
        this.mensagem = mensagem;
    }

    public Topic(Long id, String title, String curso, String autor, String mensagem) {
        this.id = id;
        this.titulo = title;
        this.curso = curso;
        this.autor = autor;
        this.mensagem = mensagem;
    }
}
