package github.com.mateusdalcantara.projeto_forum.domain.estudante;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
   Page<Estudante> findAllByAtivoTrue(Pageable paginacao);

}
