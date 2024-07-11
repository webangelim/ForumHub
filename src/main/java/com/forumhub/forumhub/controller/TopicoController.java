package com.forumhub.forumhub.controller;

import com.forumhub.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, @AuthenticationPrincipal UserDetails userDetails) {
        var email = userDetails.getUsername();
        var dto = topicoService.cadastrar(dados, email);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listar(Pageable paginacao) {
        var page = repository.findAllByStatusTrue(paginacao).map(TopicoDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            var topico = repository.getReferenceById(id);

            return ResponseEntity.ok(new TopicoDTO(topico));
        }

        return ResponseEntity.badRequest().body("Id fornecido é inválido");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados, @PathVariable Long id) {
        if (repository.existsById(id)) {
            var topico = repository.getReferenceById(id);

            topico.atualizar(dados);
            repository.save(topico);

            return ResponseEntity.ok(new DadosAtualizarTopico(topico));
        }

        return ResponseEntity.badRequest().body("Id fornecido é inválido");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        if (repository.existsById(id)) {
            var topico = repository.getReferenceById(id);
            topico.excluir();
            repository.save(topico);
        }


        return ResponseEntity.noContent().build();
    }

}
