package github.com.mateusdalcantara.projeto_forum.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TopicServices {

    @Autowired
    private TopicsRepository repository;

    public ResponseTopicDTO saveTopic(RequestTopicDTO dto){
        Topic topic = repository.save(TopicMapper.fromDTO(dto));
        return TopicMapper.toDTO(topic);
    }

    public void deleteTopic(Long id){
        repository.deleteById(id);
    }

    public ResponseTopicDTO updateTopic(Long id, RequestTopicDTO dto){
        Topic topic = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com id " + id));
        topic.setTitulo(dto.titulo());
        topic.setCurso(dto.curso());
        topic.setMensagem(dto.mensagem());
        return TopicMapper.toDTO(repository.save(topic));
    }

    public ResponseTopicDTO getTopic(Long id){
        Topic topic = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com id " + id));
        return TopicMapper.toDTO(topic);
    }

    public Page<ResponseTopicDTO> getTopicList(Pageable pageable){
        return TopicMapper.toDTO(repository.findAll(pageable));
    }
}

