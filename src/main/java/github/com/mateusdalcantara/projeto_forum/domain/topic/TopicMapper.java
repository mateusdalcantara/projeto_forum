package github.com.mateusdalcantara.projeto_forum.domain.topic;

import org.springframework.data.domain.Page;

public class TopicMapper {

    public static Topic fromDTO(RequestTopicDTO dto) {
        return new Topic(dto.titulo(), dto.curso(), dto.autor(), dto.mensagem());
    }

    public static ResponseTopicDTO toDTO(Topic topic) {
        return new ResponseTopicDTO(topic.getId(), topic.getTitulo(), topic.getMensagem(), topic.getCreation_date_time());
    }

    public static Page<ResponseTopicDTO> toDTO(Page<Topic> topics) {
        return topics.map(TopicMapper::toDTO);
    }
}
