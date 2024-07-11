package com.forumhub.forumhub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Topico getTopicoByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByStatusTrue(Pageable paginacao);
}
