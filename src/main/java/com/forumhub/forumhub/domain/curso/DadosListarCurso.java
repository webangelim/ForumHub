package com.forumhub.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosListarCurso(String nome,
                               String categoria) {

    public DadosListarCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }

}
