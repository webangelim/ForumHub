package com.forumhub.forumhub.domain.curso;

public record DadosDetalharCurso(Long id,
                                 String nome,
                                 String categoria) {

    public DadosDetalharCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }

}
