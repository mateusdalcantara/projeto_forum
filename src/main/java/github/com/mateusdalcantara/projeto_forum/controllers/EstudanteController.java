package github.com.mateusdalcantara.projeto_forum.controllers;

import github.com.mateusdalcantara.projeto_forum.domain.estudante.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value = "estudantes")
@SecurityRequirement(name = "bearer-key")
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid CadastrarEstudante dados, UriComponentsBuilder uriBuilder){
        var estudante = new Estudante(dados);
        repository.save(estudante);
        var uri = uriBuilder.path("/estudantes/{id}").buildAndExpand(estudante.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListagemCompletaEstudante(estudante));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemSimplesEstudante>> listagemSimples(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemSimplesEstudante::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarInformacoes(@RequestBody @Valid AtualizarInformacoesDoEstudante dados){
        var estudante = repository.getReferenceById(dados.id());
        estudante.atualizarInformacoes(dados);
        return ResponseEntity.ok(new ListagemCompletaEstudante(estudante));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var estudante = repository.getReferenceById(id);
        estudante.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var estudante = repository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemCompletaEstudante(estudante));
    }




}
