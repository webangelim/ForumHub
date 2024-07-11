package com.forumhub.forumhub.domain.topico;

import java.time.format.DateTimeFormatter;

public record TopicoDTO(Long id,
                        String titulo,
                        String mensagem,
                        String autor,
                        String data,
                        Boolean status,
                        String curso) {
    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getAutor().getNome(),
                topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                topico.getStatus(), topico.getCurso());
    }
}
