package github.com.mateusdalcantara.projeto_forum.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long>{
    
}
