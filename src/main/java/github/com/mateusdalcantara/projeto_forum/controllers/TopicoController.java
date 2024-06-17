package github.com.mateusdalcantara.projeto_forum.controllers;

import github.com.mateusdalcantara.projeto_forum.domain.topic.RequestTopicDTO;
import github.com.mateusdalcantara.projeto_forum.domain.topic.ResponseTopicDTO;
import github.com.mateusdalcantara.projeto_forum.domain.topic.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicServices services;

    @GetMapping("/")
    public ResponseEntity<Page<ResponseTopicDTO>> getTopicList(Pageable pageable) {
        return ResponseEntity.ok().body(services.getTopicList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok().body(services.getTopic(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        services.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<ResponseTopicDTO> saveTopic(@RequestBody RequestTopicDTO requestTopicDTO) {
        ResponseTopicDTO responseTopicDTO = services.saveTopic(requestTopicDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseTopicDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(responseTopicDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> updateTopic(@PathVariable Long id,
                                                        @RequestBody RequestTopicDTO requestTopicDTO) {
        return ResponseEntity.ok().body(services.updateTopic(id, requestTopicDTO));
    }
}

