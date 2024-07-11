package com.forumhub.forumhub.domain.topico;

import java.time.format.DateTimeFormatter;

public record DadosAtualizarTopico(String titulo,
                                   String mensagem,
                                   Boolean status,
                                   String curso) {

    public DadosAtualizarTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(),
                topico.getStatus(), topico.getCurso());
    }

}
