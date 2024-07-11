package com.forumhub.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(@NotBlank String nome,
                                 @NotBlank String categoria) {

    public DadosCadastroCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }

}
