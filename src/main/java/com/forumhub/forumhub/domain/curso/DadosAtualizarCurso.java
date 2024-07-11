package com.forumhub.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCurso(Long id,
                                  String nome,
                                  String categoria) {

    public DadosAtualizarCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }

}
